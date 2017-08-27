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
//�������ݿ�
public class SqlConn extends sqlConn{
	//�˷���ʵ�������ݿ�д������
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
			System.out.println("���ݿ�����ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("���ݿ�д��ʧ�ܣ�");
		}
	}
	//�˷���ʵ�������ݿ��ѯ��Ϣ������
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
			return "��ѯʧ�ܣ�";
		} catch (SQLException e) {
			return "��ѯʧ�ܣ�";
		}
	}
	//�˷�����֤�û��Ƿ��п�
boolean no_card(String username){
	return true;
}
	//�˷�����֤���ź������Ƿ���ȷ
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
	//�û���Ϣ���ʼ��
boolean new_user(String user_name,String user_id,String user_tel){
			String str="INSERT INTO userinfo(user_name,user_card_id,user_tel,user_date) VALUES('"+user_name+"','"+user_id+"','"+user_tel+"',CURDATE());";
			String str1="select * from userinfo;";
			String username;
			sqlUpdate(str);//���û���Ϣ���µ����ݿ�
			username=sqlSearch(str1,"user_name");//��ѯ�û���
			if(username.equals("��ѯʧ�ܣ�")){
				System.out.println("��Ϣ����ʧ�ܣ�");
				return false;
			}else{
				System.out.println("�û���"+username+"��Ϣ���³ɹ���");
				return true;
			}
			}
//����Ϣ���ʼ�������¿���
boolean new_card(String user_name,String card_passwd){
			double card_money=0;//�������
			long card_newno=622210000;//����
			String cardno,cardmoney,cardid,userid,dq_money;
			String str="select user_id from userinfo where user_id='"+user_name+"';";
			userid=sqlSearch(str,"user_id");//��ѯ�û�id
			String str1="INSERT INTO cardinfo(card_no,card_passwd,card_money,user_id) VALUES('"+card_newno+"','"+card_passwd+"','"+card_money+"','"+userid+"');";
			sqlUpdate(str1);//���¿���Ϣ�����ݿ��cardinfo��
			String str2="select * from cardinfo where user_id='"+userid+"';";
			cardno=sqlSearch(str2,"card_no");//��ȡ����
			cardmoney=sqlSearch(str2,"card_money");//��ȡ�������
			cardid=sqlSearch(str2,"card_id");//��ȡ�Զ����ɵ�card_id
			String str3="INSERT INTO timeposit(ck_money,card_id) VALUES('"+card_money+"','"+cardid+"');";
			sqlUpdate(str3);//���¶��ڴ����Ϣ����timeposit��
			String str4="select ck_money from timeposit where card_id='"+cardid+"';";
			dq_money=sqlSearch(str4,"ck_money");//��ѯ���ڴ��#################	
			if(cardno.equals("��ѯʧ��")){
				System.out.println("����"+cardno);
				return false;
			}else if(cardmoney.equals("��ѯʧ�ܣ�")){
				System.out.println("��ѯʧ�ܣ�"+cardmoney);
				return false;
			}else if(cardid.equals("��ѯʧ�ܣ�")){
				System.out.println("��id"+cardid);
				return false;
			}else if(userid.equals("��ѯʧ�ܣ�")){
				System.out.println("�û�id"+userid);
				return false;
			}else if(dq_money.equals("��ѯʧ�ܣ�")){
				System.out.println("�������"+dq_money);
				return false;
			}else{
				System.out.println("�����ɹ���\n���Ŀ���Ϊ��"+cardno+"\n��ǰ�������Ϊ��"+cardmoney+"Ԫ\n��ǰ�������Ϊ��"+dq_money+"Ԫ");
				return true;
			}
	}

	//�˷���ʵ�ֲ�ѯ�����Ϣ��֤�ɹ�����ʾ���Ŵ����Ϣ
String[] serchinfo(String card_no,String card_passwd){
		String str="select card_id from cardinfo where card_no='"+card_no+"';";
		String cardid;
		String hq_money = null,dq_money = null;
		String[] money={hq_money,dq_money};
		cardid=sqlSearch(str,"card_id");//��ѯ��id	
		String str1="select card_money from cardinfo where card_id='"+card_no+"';";
		String str2="select ck_money from timedeposit where card_id='"+cardid+"';";
		hq_money=sqlSearch(str1,"card_money");//��ѯ�������
		dq_money=sqlSearch(str2,"ck_money");//��ѯ�������
		if(hq_money.equals("��ѯʧ�ܣ�")){
			hq_money="0.0";
		}else if(dq_money.equals("��ѯʧ�ܣ�")){
			dq_money="0.0";
		}
		return money;
	}

			//�˷���ʵ�ֻ��ڴ��
boolean card_hqmoney(String card_no,int money){
		String str="update cardinfo set card_moeny='"+money+"' where card_no='"+card_no+"';";
		String str1="select card_money from cardinfo where card_no='"+card_no+"';";
		String cardmoney;
		sqlUpdate(str);	//���»������
		cardmoney=sqlSearch(str1,"card_money");
		if(cardmoney.equals("��ѯʧ�ܣ�")){
			System.out.println(cardmoney);
			return false;
		}else{
			System.out.println("���ɹ�����ǰ�������Ϊ��"+cardmoney);
			return true;
		}
		}

				//�˷���ʵ�ֶ��ڴ��
boolean card_dqmoney(String card_no,int money,int date){
		String str="select card_id from cardinfo where card_no='"+card_no+"';";
		String cardid,dq_money,dq_time,dq_kstime;
		cardid=sqlSearch(str,"card_id");//��ȡ��id
		String str1="update timedeposit set card_moeny='"+money+"' where card_id='"+cardid+"';";
		String str2="update timedeposit set ck_type='"+date+"' where card_id='"+cardid+"';";
		String str3="update timedeposit set ck_start_date=CURDATE() where card_id='"+cardid+"';";
		String str4="select * from timedeposit;";
		sqlUpdate(str1);//���¶������
		sqlUpdate(str2);//���¶���ʱ��
		sqlUpdate(str3);//���¶��ڿ�ʼ����
		dq_money=sqlSearch(str4,"ck_money");
		dq_time=sqlSearch(str4,"ck_type");
		dq_kstime=sqlSearch(str4,"ck_start_date");
		if(dq_money.equals("��ѯʧ�ܣ�")){
			System.out.println("dq_money"+dq_money);
			return false;
		}else if(dq_time.equals("��ѯʧ�ܣ�")){
			System.out.println("dq_time"+dq_time);
			return false;
		}else if(dq_kstime.equals("��ѯʧ�ܣ�")){
			System.out.println("dq_kstime"+dq_kstime);
			return false;
		}else{
			System.out.println("���ڴ�����ɹ���\n��ǰ������Ϊ��"+dq_money+"���ʱ��Ϊ��"+dq_time+"����\n���ʱ�䣺"+dq_kstime);
			return true;
		}
		}
}

	

