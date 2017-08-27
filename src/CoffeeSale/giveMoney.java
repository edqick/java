package CoffeeSale;

import java.security.PrivateKey;
import java.util.Scanner;
	/*	此类实现零钱组合计算
	 * outMoney:应找出零钱数量
	 * 	stayMoney:剩余零钱数量
	 * 	trueMoney:实际找出零钱数量
	 * 	meMoney:零钱面额
	 * 	nameMoney：零钱名字
	 * */
abstract class Money{
	private int[] outMoney,stayMoney,trueMoney,meMoney;
	private String[] nameMoney;
	public void setOutMoney(int[] outMoney) {
		this.outMoney = outMoney;
	}
	public int[] getOutMoney() {
		return outMoney;
	}
	public void setStayMoney(int[] stayMoney) {
		this.stayMoney = stayMoney;
	}
	public int[] getStayMoney() {
		return stayMoney;
	}
	public void setTrueMoney(int[] trueMoney) {
		this.trueMoney = trueMoney;
	}
	public int[] getTrueMoney() {
		return trueMoney;
	}
	public void setMeMoney(int[] meMoney) {
		this.meMoney = meMoney;
	}
	public int[] getMeMoney() {
		return meMoney;
	}
	public void setNameMoney(String[] nameMoney) {
		this.nameMoney = nameMoney;
	}
	public String[] getNameMoney() {
		return nameMoney;
	}
	public abstract  void pocketMoney();
}
public  class  giveMoney extends Money {
			int[] all0 = new int[5];		//应找出零钱数量，all0[0]代表1元零钱张数，all[1]代表5元零钱张数，以此类推
			int[] n0 = new int[5];			//剩余零钱数量，n0[0]代表1元，n0[1]代表5元，n0[2]代表10元，以此类推
			int[] all1 = {0,0,0,0,0};		//实际找出零钱数量
			int[] m0={1,5,10,20,50};		//零钱面额
			String[] s = {"1元","5元","10元","20元","50元",};//零钱的名字
			private int i,j,k ;
	
	public giveMoney(){//数据初始化
			setOutMoney(all0);
			setStayMoney(n0);
			setTrueMoney(all1);
			setMeMoney(m0);
			setNameMoney(s);
			}
	public void pocketMoney(){
		pocketMoney();
	}
	public void sum(int money){		//计算组合
			//all_5:money分解为5元的总张数
			int all=0;//为吐出钱的张数
			String[] str0 ={"找您:"," 共计：","张","元。谢谢光临！欢迎下次再来哦！"};
			int all_5=money/5;	//得到分解为5元的总张数
			all0[0]=money%5;	//得到1元的张数
			all0[4]=all_5/10;	//得到50元的张数
			all0[3]=(all_5%10)/4;	//得到20元的张数
			all0[2]=((all_5%10)%4)/2;//得到10元的张数
			all0[1]=all_5-(all0[4]*10+all0[3]*4+all0[2]*2);//组合之后的5元实际张数
			for(k=all0.length;k>0;k--){
				if(all0[k-1]<n0[k-1]){
					all1[k-1]=all0[k-1];
					n0[k-1]=n0[k-1]-all1[k-1];	//重置零钱剩余的数量
				}else{
					all1[k-1]=n0[k-1];
					n0[k-1]=0;					//重置零钱剩余的数量
					if(k==5){					//当50元面额零钱不足时，溢出的数量转换为20元面额零钱
						if((all0[k-1]-n0[k-1])%2==0){
							all1[k-2]=all1[k-2]+((all0[k-1]-n0[k-1])*m0[k-1])/m0[k-2];
						}else{
							all1[k-2]=all1[k-2]+(((all0[k-1]-n0[k-1])-1)*m0[k-1])/m0[k-2];
							all1[k-3]=all1[k-3]+1;
							}
					}else if(k==2){				//5元面额零钱不足时溢出的数量转换为1元面额零钱
						all0[k-2]=all0[k-2]+(all0[k-1]-n0[k-1])*5;
					}else if(k==1){
						System.out.println("哎呀！零钱不足啦！");//1元面额零钱不足。
						break;
					}else{						//20元、10元面额零钱不足时溢出的数量转换为10、5元面额零钱
						all1[k-2]=all1[k-2]+(all0[k-1]-n0[k-1])*2;
						}
					}
				}
			for(i=0;i<all1.length;i++){
				//System.out.println(all0[i]);
					all=all+all1[i];
				//System.out.println(all);
			}
			System.out.print(str0[0]);
			for(j=0;j<all1.length;j++){		//输出对应金额的数量
				if(all1[j]!=0){
					System.out.print(all1[j]+"张"+s[j]+"  ");
				}
			}
			System.out.println(str0[1]+all+str0[2]+money+str0[3]);
		}
		  public int[] set(){			//设置零钱
			 /* for(i=0;i<n0.length;i++){
					System.out.println("请输入初始的"+s[i]+"零钱张数：");
					Scanner sc = new Scanner(System.in);
					n0[i] = sc.nextInt();
				}*/
			  	n0[0]=n0[1]=n0[2]=n0[3]=n0[4]=100;
				System.out.println("设置完成！");
				chaxun();
			  return n0;
		  }
		  public void chaxun(){			//查询零钱
			  for(int i=0;i<n0.length;i++){
					System.out.println("当前系统有："+s[i]+n0[i]+"张");
				}
		  }
		

}

