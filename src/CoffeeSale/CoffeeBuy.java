package CoffeeSale;
import java.util.Scanner;
abstract class Coffee{
	private int CarNum=0;
	protected int AllPrice=0;
	//��Ʒ����
	private String coffee[][]={{"1","ȸ������"},{"2","��ɽ����"},{"3","èʺ����"}};
	//��Ʒ��Ӧ�۸�
	private int[] price={8,12,15};
	public abstract int coffeBuy();
	public void setCarNum(int carNum) {
		CarNum = carNum;
	}
	public int getCarNum() {//��ȡ���ﳵ��Ʒ��
		return CarNum;
	}
	public void setAllPrice(int allPrice) {
		AllPrice = allPrice;
	}
	public int getAllPrice() {//��ȡ���ﳵ�ܼ�
		return AllPrice;
	}
	public void setCoffee(String coffee[][]) {//��ȡ������Ϣ
		this.coffee = coffee;
	}
	public String[][] getCoffee() {
		return coffee;
	}
	public void setPrice(int[] price) {
		this.price = price;
	}
	public int[] getPrice() {//��ȡ���ȼ۸�
		return price;
	}
	
}

public class CoffeeBuy extends Coffee{		
	public int coffeBuy(){			//���򿧷�
		boolean conBuy=true;
		String user0,user1;
		int CarNum=getCarNum();
		int AllPrice=getAllPrice();
		String[][] coffee=getCoffee();
		int[] price=getPrice();
		Scanner sc = new Scanner(System.in);
		System.out.println("���ã���ӭ���򿧷ȣ�");
		while(conBuy){
		System.out.println("1.ȸ�����ȡ�8Ԫ��\t2.��ɽ���ȡ�12Ԫ��\t3.èʺ���ȡ�15Ԫ��\n������Ҫ����Ŀ��ȣ�");
		user0=sc.next();
		for(int i=0;i<coffee.length;i++){
			for(int j=0;j<coffee[i].length;j++){
				if(user0.equals(coffee[i][j])){
					CarNum+=1;
					AllPrice+=price[i];
					break;
				}
			}
			}
		//System.out.println(AllPrice+"he"+CarNum);
		System.out.println("���ﳵ��ӳɹ���\n�Ƿ��������\t1.��\t2.��");
		user1=sc.next();
		if(user1.equals("2")||user1.equals("��")){
			conBuy=false;
		}}
		System.out.println("���ﳵ����"+CarNum+"����Ʒ���ܼƣ�"+AllPrice+"Ԫ��\n��Ͷ�ң�");
		return AllPrice;
	}
	
}
