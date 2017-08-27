package CoffeeSale;

import java.util.Scanner;

public class SaleMain {

	/**@param args
	 *这是一个简单的咖啡售卖系统
	 * 1.用户选择相应的咖啡购买
	 * 2.投入现金
	 * 3.系统自动计算商品总价以及应该找出的零钱最优组合
	 * 4.输出相应的数据
	 */
	public static void main(String[] args) {
			int userMoney=0;		//假设顾客只允许投入50元或100元现金
			giveMoney gm = new giveMoney();
			gm.set();		//设置系统零钱
			CoffeeBuy cb = new CoffeeBuy();
			int coffeMoney=cb.coffeBuy();
			//m.chaxun();		//查询当前系统剩余零钱情况
			System.out.println("请投入100元或50元现金。");
			Scanner sc = new Scanner(System.in);
			while(true){
			userMoney+= sc.nextInt();					//假设money不为0
			System.out.println("已投入金额："+userMoney);
			if(userMoney<coffeMoney){
				System.out.println("请继续投币：");
			}else{
				gm.sum(userMoney-coffeMoney);
				break;
			}
			}
	}

}
