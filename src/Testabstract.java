import java.util.Scanner;
abstract class Card{
	private String cardNo="6225881284968855";
	private String cardPassWord="123456";
	double accountYE=100000.00;
  
  public String getCardNo(){
  		return cardNo;
  }
  public String getCardPassWord(){
  		return cardPassWord;
  }
  public abstract void TakeMoney();
}
class TakeMoney extends Card{
	public void TakeMoney() {
		getCardNo();
		getCardPassWord();
	}
	
	public String getCardNo(){//��ȡ����
		return super.getCardNo();
  }
  public String getCardPassWord(){//��ȡ����
	  	return super.getCardPassWord();
  }
  public double TakeMoney(String cardno,String cardpassword,double money){
  		if(cardno.equals(getCardNo())&&cardpassword.equals(getCardPassWord())){
  			accountYE-=money;
  		}
  		System.out.println("ȡ��ɹ�����ǰ���Ϊ��"+accountYE);
  		return accountYE;
  	}
}
	public class Testabstract{
	public static void main(String args[]){
		String cardno,cardpassword;
		double money;
		boolean su=true;
		Scanner sc= new Scanner(System.in);
		TakeMoney tm=new TakeMoney();
		while(su){
			System.out.println("�����뿨�ţ�");
			cardno=sc.next();
			System.out.println("���������룺");
			cardpassword=sc.next();
			if(!cardno.equals(tm.getCardNo())||!cardpassword.equals(tm.getCardPassWord())){
  			System.out.println("���������Ϣ��������������");
  		}else{
  			System.out.println("�˺���֤�ɹ���������ȡ���");
				money=sc.nextDouble();
				tm.TakeMoney(cardno,cardpassword,money);
				su=false;
  			}
  		}
		}
	}