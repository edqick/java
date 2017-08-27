import java.sql.*;
abstract class sqlConn{
	private String url="jdbc:mysql://localhost:3306/card";
	private String userName="root";
	private String passWord="123456";
	private Connection cn=null;
	private Statement st=null;
	private ResultSet rs=null;
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setCn(Connection cn) {
		this.cn = cn;
	}
	public Connection getCn() {
		return cn;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
	public Statement getSt() {
		return st;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public ResultSet getRs() {
		return rs;
	}
	}
//连接数据库
public class SqlConn extends sqlConn{
	//此方法实现向数据库写入数据
	void sqlUpdate(String sql){
		try {
			Class.forName(getUrl());
			Connection cn=getCn();
			cn=DriverManager.getConnection(getUrl(),getUserName(),getPassWord());
			Statement st=getSt();
			st=cn.createStatement();
			st.executeUpdate(sql);
			st.close();
			cn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("数据库连接失败！");
		} catch (SQLException e) {
			System.out.println("数据库写入失败！");
		}
	}
	//此方法实现向数据库查询信息并返回
	String sqlSearch(String sql,String serachcolum){
		String result;
		try {
			Class.forName(getUrl());
			Connection cn=getCn();
			cn=DriverManager.getConnection(getUrl(),getUserName(),getPassWord());
			Statement st=getSt();
			st=cn.createStatement();
			ResultSet rs=getRs();
			rs=st.executeQuery(sql);
			rs.next();
			result=rs.getString(serachcolum);
			rs.close();
			st.close();
			cn.close();
			return result;
		} catch (ClassNotFoundException e) {
			return "查询失败！";
		} catch (SQLException e) {
			return "查询失败！";
		}
	}
	//此方法验证用户是否有卡
boolean no_card(String username){
	return true;
}
	//此方法验证卡号和密码是否正确
boolean true_card(String card_no,String card_passwd){
	String str="select card_passwd from cardinfo where card_no='"+card_no+"';";
	String cardpasswd;
	cardpasswd=sqlSearch(str,"card_passwd");
	if(card_passwd.equals(cardpasswd)){
		return true;
	}else{
		return false;
	}
}
	//用户信息表初始化
boolean new_user(String user_name,String user_id,String user_tel){
			String str="INSERT INTO userinfo(user_name,user_card_id,user_tel,user_date) VALUES('"+user_name+"','"+user_id+"','"+user_tel+"',CURDATE());";
			String str1="select * from userinfo;";
			String username;
			sqlUpdate(str);//将用户信息更新到数据库
			username=sqlSearch(str1,"user_name");//查询用户名
			if(username.equals("查询失败！")){
				System.out.println("信息更新失败！");
				return false;
			}else{
				System.out.println("用户："+username+"信息更新成功！");
				return true;
			}
			}
//卡信息表初始化（开新卡）
boolean new_card(String user_name,String card_passwd){
			double card_money=0;//活期余额
			long card_newno=622210000;//卡号
			String cardno,cardmoney,cardid,userid,dq_money;
			String str="select user_id from userinfo where user_id='"+user_name+"';";
			userid=sqlSearch(str,"user_id");//查询用户id
			String str1="INSERT INTO cardinfo(card_no,card_passwd,card_money,user_id) VALUES('"+card_newno+"','"+card_passwd+"','"+card_money+"','"+userid+"');";
			sqlUpdate(str1);//更新卡信息到数据库表cardinfo中
			String str2="select * from cardinfo where user_id='"+userid+"';";
			cardno=sqlSearch(str2,"card_no");//获取卡号
			cardmoney=sqlSearch(str2,"card_money");//获取活期余额
			cardid=sqlSearch(str2,"card_id");//获取自动生成的card_id
			String str3="INSERT INTO timeposit(ck_money,card_id) VALUES('"+card_money+"','"+cardid+"');";
			sqlUpdate(str3);//更新定期存款信息到表timeposit中
			String str4="select ck_money from timeposit where card_id='"+cardid+"';";
			dq_money=sqlSearch(str4,"ck_money");//查询定期存款#################	
			if(cardno.equals("查询失败")){
				System.out.println("卡号"+cardno);
				return false;
			}else if(cardmoney.equals("查询失败！")){
				System.out.println("查询失败！"+cardmoney);
				return false;
			}else if(cardid.equals("查询失败！")){
				System.out.println("卡id"+cardid);
				return false;
			}else if(userid.equals("查询失败！")){
				System.out.println("用户id"+userid);
				return false;
			}else if(dq_money.equals("查询失败！")){
				System.out.println("定期余额"+dq_money);
				return false;
			}else{
				System.out.println("开卡成功！\n您的卡号为："+cardno+"\n当前活期余额为："+cardmoney+"元\n当前定期余额为："+dq_money+"元");
				return true;
			}
	}

	//此方法实现查询存款信息验证成功后，显示卡号存款信息
String[] serchinfo(String card_no,String card_passwd){
		String str="select card_id from cardinfo where card_no='"+card_no+"';";
		String cardid;
		String hq_money = null,dq_money = null;
		String[] money={hq_money,dq_money};
		cardid=sqlSearch(str,"card_id");//查询卡id	
		String str1="select card_money from cardinfo where card_id='"+card_no+"';";
		String str2="select ck_money from timedeposit where card_id='"+cardid+"';";
		hq_money=sqlSearch(str1,"card_money");//查询活期余额
		dq_money=sqlSearch(str2,"ck_money");//查询定期余额
		if(hq_money.equals("查询失败！")){
			hq_money="0.0";
		}else if(dq_money.equals("查询失败！")){
			dq_money="0.0";
		}
		return money;
	}

			//此方法实现活期存款
boolean card_hqmoney(String card_no,int money){
		String str="update cardinfo set card_moeny='"+money+"' where card_no='"+card_no+"';";
		String str1="select card_money from cardinfo where card_no='"+card_no+"';";
		String cardmoney;
		sqlUpdate(str);	//更新活期余额
		cardmoney=sqlSearch(str1,"card_money");
		if(cardmoney.equals("查询失败！")){
			System.out.println(cardmoney);
			return false;
		}else{
			System.out.println("存款成功！当前活期余额为："+cardmoney);
			return true;
		}
		}

				//此方法实现定期存款
boolean card_dqmoney(String card_no,int money,int date){
		String str="select card_id from cardinfo where card_no='"+card_no+"';";
		String cardid,dq_money,dq_time,dq_kstime;
		cardid=sqlSearch(str,"card_id");//获取卡id
		String str1="update timedeposit set card_moeny='"+money+"' where card_id='"+cardid+"';";
		String str2="update timedeposit set ck_type='"+date+"' where card_id='"+cardid+"';";
		String str3="update timedeposit set ck_start_date=CURDATE() where card_id='"+cardid+"';";
		String str4="select * from timedeposit;";
		sqlUpdate(str1);//更新定期余额
		sqlUpdate(str2);//更新定期时间
		sqlUpdate(str3);//更新定期开始日期
		dq_money=sqlSearch(str4,"ck_money");
		dq_time=sqlSearch(str4,"ck_type");
		dq_kstime=sqlSearch(str4,"ck_start_date");
		if(dq_money.equals("查询失败！")){
			System.out.println("dq_money"+dq_money);
			return false;
		}else if(dq_time.equals("查询失败！")){
			System.out.println("dq_time"+dq_time);
			return false;
		}else if(dq_kstime.equals("查询失败！")){
			System.out.println("dq_kstime"+dq_kstime);
			return false;
		}else{
			System.out.println("定期存款存入成功！\n当前定期月为："+dq_money+"存款时长为："+dq_time+"个月\n存款时间："+dq_kstime);
			return true;
		}
		}
}

	

