package CoffeeSale;
import java.util.Scanner;
abstract class Coffee{
	private int CarNum=0;
	protected int AllPrice=0;
	//商品种类
	private String coffee[][]={{"1","雀巢咖啡"},{"2","蓝山咖啡"},{"3","猫屎咖啡"}};
	//商品对应价格
	private int[] price={8,12,15};
	public abstract int coffeBuy();
	public void setCarNum(int carNum) {
		CarNum = carNum;
	}
	public int getCarNum() {//获取购物车商品数
		return CarNum;
	}
	public void setAllPrice(int allPrice) {
		AllPrice = allPrice;
	}
	public int getAllPrice() {//获取购物车总价
		return AllPrice;
	}
	public void setCoffee(String coffee[][]) {//获取咖啡信息
		this.coffee = coffee;
	}
	public String[][] getCoffee() {
		return coffee;
	}
	public void setPrice(int[] price) {
		this.price = price;
	}
	public int[] getPrice() {//获取咖啡价格
		return price;
	}
	
}

public class CoffeeBuy extends Coffee{		
	public int coffeBuy(){			//购买咖啡
		boolean conBuy=true;
		String user0,user1;
		int CarNum=getCarNum();
		int AllPrice=getAllPrice();
		String[][] coffee=getCoffee();
		int[] price=getPrice();
		Scanner sc = new Scanner(System.in);
		System.out.println("您好！欢迎购买咖啡！");
		while(conBuy){
		System.out.println("1.雀巢咖啡【8元】\t2.蓝山咖啡【12元】\t3.猫屎咖啡【15元】\n请输入要购买的咖啡：");
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
		System.out.println("购物车添加成功！\n是否继续购买？\t1.是\t2.否");
		user1=sc.next();
		if(user1.equals("2")||user1.equals("否")){
			conBuy=false;
		}}
		System.out.println("购物车结算"+CarNum+"件商品，总计："+AllPrice+"元！\n请投币！");
		return AllPrice;
	}
	
}
