import java.util.*;
/** 一卡通系统
 *  1.开卡
 *  2.查询
 *  3.存款
 *  4.取款
 *  5.退出系统
 * */
public class enterPro {
//欢迎界面
public static  void welcome(){
	System.out.println("##########################################");
	System.out.println("##\t\t1.开卡\t\t##");
	System.out.println("##\t\t2.查询\t\t\t##");
	System.out.println("##\t\t3.存款\t\t\t##");
	System.out.println("##\t\t4.取款\t\t\t##");
	System.out.println("##\t\t5.退出系统\t\t\t##");
	System.out.println("##########################################");
	System.out.println("请选择您需要的操作：");
	System.out.println("##########################################");
}

//验证身份证号码格式
static boolean useridtrue(String user_id){
	return true;
}
//验证姓名格式
static boolean usernametrue(String user_name){
	return true;
}
//验证密码格式
static boolean cardpasswdtrue(String card_passwd){
	return true;
}
//验证电话号码格式
static boolean usertel(String user_tel){
	return true;
}
/*身份证号：必填，18位，最后一位可以为x。如果输入错误，系统提示“身份证错误，请重新输入”。
姓名：必填，1-20位，如果输入错误，系统提示“姓名错误，请重新输入”。
密码：必填，6位，如果输入错误，系统提示“密码错误，请重新输入”。
确认密码：必填，6位，与密码一直，如果输入错误，系统提示“两次密码不一致，请重新输入”。
手机号：必填，11位。如果输入错误，系统提示“手机号错误，请重新输入”。
 * */
//开卡
public static  void kaika(){
	String user_name,user_id,card_passwd,user_tel,recard_passwd;
	boolean id=true,name=true,pwd=true,tel=true;
	Scanner sc=new Scanner(System.in);
	while(id){//验证身份证号码
	System.out.println("##########################################\n请输入身份证号：");
	user_id=sc.next();
	if(useridtrue(user_id)){
		id=false;
		while(name){//验证用户名
		System.out.println("请输入用户名：");
		user_name=sc.next();
		if(usernametrue(user_name)){
			name=false;
			while(pwd){//验证密码
			System.out.println("请输入密码：");
			card_passwd=sc.next();
			System.out.println("请再次输入密码：");
			recard_passwd=sc.next();
			if(card_passwd.equals(recard_passwd)){
				if(cardpasswdtrue(card_passwd)){
					pwd=false;
					while(tel){//验证电话号码
					System.out.println("请输入11位手机号：");
					user_tel=sc.next();
					if(usertel(user_tel)){
						tel=false;
						//所有数据填写正确
						SqlConn sqc=new SqlConn();
						sqc.new_user(user_name, user_id, user_tel);
					}else{
						System.out.println("电话号码格式错误，请重新输入！");
					}
					}
				}else{
					System.out.println("密码格式错误，请重新输入！");
				}
			}else{
				System.out.println("两次密码不一致，请重新输入！");
			}
			}
		}else{
			System.out.println("用户姓名格式错误！请重新输入！");
		}
		}
	}else{
		System.out.println("身份证号码格式错误！请重新输入！");
	}
	}
	
	
	
}
//查询
public static void chaxun(){
	
}
//存款
public static void cunkuan(){
	
}
//取款
public static void qukuan(){
	
}
//退出系统
public static void tuichu(){
	
}
public static void main(String[] args) {
	String in;
	boolean istrue=true;
	welcome();
	Scanner sc=new Scanner(System.in);
	while(istrue){
	in=sc.next();
	if(in.equals("1")||in.equals("开卡")){
		kaika();
	}else if(in.equals("2")||in.equals("查询")){
		chaxun();
	}else if(in.equals("3")||in.equals("存款")){
		cunkuan();
	}else if(in.equals("4")||in.equals("取款")){
		qukuan();
	}else if(in.equals("5")||in.equals("退出系统")||in.equals("退出")){
		tuichu();
	}else{
		System.out.println("输入错误请重新输入！");
	}
	}
		
}
}

