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
	
	public String getCardNo(){//获取卡号
		return super.getCardNo();
  }
  public String getCardPassWord(){//获取密码
	  	return super.getCardPassWord();
  }
  public double TakeMoney(String cardno,String cardpassword,double money){
  		if(cardno.equals(getCardNo())&&cardpassword.equals(getCardPassWord())){
  			accountYE-=money;
  		}
  		System.out.println("取款成功，当前余额为："+accountYE);
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
			System.out.println("请输入卡号：");
			cardno=sc.next();
			System.out.println("请输入密码：");
			cardpassword=sc.next();
			if(!cardno.equals(tm.getCardNo())||!cardpassword.equals(tm.getCardPassWord())){
  			System.out.println("您输入的信息有误！请重新输入");
  		}else{
  			System.out.println("账号验证成功，请输入取款金额：");
				money=sc.nextDouble();
				tm.TakeMoney(cardno,cardpassword,money);
				su=false;
  			}
  		}
		}
	}