package CoffeeSale;

import java.util.Scanner;

public class SaleMain {

	/**@param args
	 *����һ���򵥵Ŀ�������ϵͳ
	 * 1.�û�ѡ����Ӧ�Ŀ��ȹ���
	 * 2.Ͷ���ֽ�
	 * 3.ϵͳ�Զ�������Ʒ�ܼ��Լ�Ӧ���ҳ�����Ǯ�������
	 * 4.�����Ӧ������
	 */
	public static void main(String[] args) {
			int userMoney=0;		//����˿�ֻ����Ͷ��50Ԫ��100Ԫ�ֽ�
			giveMoney gm = new giveMoney();
			gm.set();		//����ϵͳ��Ǯ
			CoffeeBuy cb = new CoffeeBuy();
			int coffeMoney=cb.coffeBuy();
			//m.chaxun();		//��ѯ��ǰϵͳʣ����Ǯ���
			System.out.println("��Ͷ��100Ԫ��50Ԫ�ֽ�");
			Scanner sc = new Scanner(System.in);
			while(true){
			userMoney+= sc.nextInt();					//����money��Ϊ0
			System.out.println("��Ͷ���"+userMoney);
			if(userMoney<coffeMoney){
				System.out.println("�����Ͷ�ң�");
			}else{
				gm.sum(userMoney-coffeMoney);
				break;
			}
			}
	}

}
