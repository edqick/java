import java.util.*;
/** һ��ͨϵͳ
 *  1.����
 *  2.��ѯ
 *  3.���
 *  4.ȡ��
 *  5.�˳�ϵͳ
 * */
public class enterPro {
//��ӭ����
public static  void welcome(){
	System.out.println("##########################################");
	System.out.println("##\t\t1.����\t\t##");
	System.out.println("##\t\t2.��ѯ\t\t\t##");
	System.out.println("##\t\t3.���\t\t\t##");
	System.out.println("##\t\t4.ȡ��\t\t\t##");
	System.out.println("##\t\t5.�˳�ϵͳ\t\t\t##");
	System.out.println("##########################################");
	System.out.println("��ѡ������Ҫ�Ĳ�����");
	System.out.println("##########################################");
}

//��֤���֤�����ʽ
static boolean useridtrue(String user_id){
	return true;
}
//��֤������ʽ
static boolean usernametrue(String user_name){
	return true;
}
//��֤�����ʽ
static boolean cardpasswdtrue(String card_passwd){
	return true;
}
//��֤�绰�����ʽ
static boolean usertel(String user_tel){
	return true;
}
/*���֤�ţ����18λ�����һλ����Ϊx������������ϵͳ��ʾ�����֤�������������롱��
���������1-20λ������������ϵͳ��ʾ�������������������롱��
���룺���6λ������������ϵͳ��ʾ������������������롱��
ȷ�����룺���6λ��������һֱ������������ϵͳ��ʾ���������벻һ�£����������롱��
�ֻ��ţ����11λ������������ϵͳ��ʾ���ֻ��Ŵ������������롱��
 * */
//����
public static  void kaika(){
	String user_name,user_id,card_passwd,user_tel,recard_passwd;
	boolean id=true,name=true,pwd=true,tel=true;
	Scanner sc=new Scanner(System.in);
	while(id){//��֤���֤����
	System.out.println("##########################################\n���������֤�ţ�");
	user_id=sc.next();
	if(useridtrue(user_id)){
		id=false;
		while(name){//��֤�û���
		System.out.println("�������û�����");
		user_name=sc.next();
		if(usernametrue(user_name)){
			name=false;
			while(pwd){//��֤����
			System.out.println("���������룺");
			card_passwd=sc.next();
			System.out.println("���ٴ��������룺");
			recard_passwd=sc.next();
			if(card_passwd.equals(recard_passwd)){
				if(cardpasswdtrue(card_passwd)){
					pwd=false;
					while(tel){//��֤�绰����
					System.out.println("������11λ�ֻ��ţ�");
					user_tel=sc.next();
					if(usertel(user_tel)){
						tel=false;
						//����������д��ȷ
						SqlConn sqc=new SqlConn();
						sqc.new_user(user_name, user_id, user_tel);
					}else{
						System.out.println("�绰�����ʽ�������������룡");
					}
					}
				}else{
					System.out.println("�����ʽ�������������룡");
				}
			}else{
				System.out.println("�������벻һ�£����������룡");
			}
			}
		}else{
			System.out.println("�û�������ʽ�������������룡");
		}
		}
	}else{
		System.out.println("���֤�����ʽ�������������룡");
	}
	}
	
	
	
}
//��ѯ
public static void chaxun(){
	
}
//���
public static void cunkuan(){
	
}
//ȡ��
public static void qukuan(){
	
}
//�˳�ϵͳ
public static void tuichu(){
	
}
public static void main(String[] args) {
	String in;
	boolean istrue=true;
	welcome();
	Scanner sc=new Scanner(System.in);
	while(istrue){
	in=sc.next();
	if(in.equals("1")||in.equals("����")){
		kaika();
	}else if(in.equals("2")||in.equals("��ѯ")){
		chaxun();
	}else if(in.equals("3")||in.equals("���")){
		cunkuan();
	}else if(in.equals("4")||in.equals("ȡ��")){
		qukuan();
	}else if(in.equals("5")||in.equals("�˳�ϵͳ")||in.equals("�˳�")){
		tuichu();
	}else{
		System.out.println("����������������룡");
	}
	}
		
}
}

