package CoffeeSale;

import java.security.PrivateKey;
import java.util.Scanner;
	/*	����ʵ����Ǯ��ϼ���
	 * outMoney:Ӧ�ҳ���Ǯ����
	 * 	stayMoney:ʣ����Ǯ����
	 * 	trueMoney:ʵ���ҳ���Ǯ����
	 * 	meMoney:��Ǯ���
	 * 	nameMoney����Ǯ����
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
			int[] all0 = new int[5];		//Ӧ�ҳ���Ǯ������all0[0]����1Ԫ��Ǯ������all[1]����5Ԫ��Ǯ�������Դ�����
			int[] n0 = new int[5];			//ʣ����Ǯ������n0[0]����1Ԫ��n0[1]����5Ԫ��n0[2]����10Ԫ���Դ�����
			int[] all1 = {0,0,0,0,0};		//ʵ���ҳ���Ǯ����
			int[] m0={1,5,10,20,50};		//��Ǯ���
			String[] s = {"1Ԫ","5Ԫ","10Ԫ","20Ԫ","50Ԫ",};//��Ǯ������
			private int i,j,k ;
	
	public giveMoney(){//���ݳ�ʼ��
			setOutMoney(all0);
			setStayMoney(n0);
			setTrueMoney(all1);
			setMeMoney(m0);
			setNameMoney(s);
			}
	public void pocketMoney(){
		pocketMoney();
	}
	public void sum(int money){		//�������
			//all_5:money�ֽ�Ϊ5Ԫ��������
			int all=0;//Ϊ�³�Ǯ������
			String[] str0 ={"����:"," ���ƣ�","��","Ԫ��лл���٣���ӭ�´�����Ŷ��"};
			int all_5=money/5;	//�õ��ֽ�Ϊ5Ԫ��������
			all0[0]=money%5;	//�õ�1Ԫ������
			all0[4]=all_5/10;	//�õ�50Ԫ������
			all0[3]=(all_5%10)/4;	//�õ�20Ԫ������
			all0[2]=((all_5%10)%4)/2;//�õ�10Ԫ������
			all0[1]=all_5-(all0[4]*10+all0[3]*4+all0[2]*2);//���֮���5Ԫʵ������
			for(k=all0.length;k>0;k--){
				if(all0[k-1]<n0[k-1]){
					all1[k-1]=all0[k-1];
					n0[k-1]=n0[k-1]-all1[k-1];	//������Ǯʣ�������
				}else{
					all1[k-1]=n0[k-1];
					n0[k-1]=0;					//������Ǯʣ�������
					if(k==5){					//��50Ԫ�����Ǯ����ʱ�����������ת��Ϊ20Ԫ�����Ǯ
						if((all0[k-1]-n0[k-1])%2==0){
							all1[k-2]=all1[k-2]+((all0[k-1]-n0[k-1])*m0[k-1])/m0[k-2];
						}else{
							all1[k-2]=all1[k-2]+(((all0[k-1]-n0[k-1])-1)*m0[k-1])/m0[k-2];
							all1[k-3]=all1[k-3]+1;
							}
					}else if(k==2){				//5Ԫ�����Ǯ����ʱ���������ת��Ϊ1Ԫ�����Ǯ
						all0[k-2]=all0[k-2]+(all0[k-1]-n0[k-1])*5;
					}else if(k==1){
						System.out.println("��ѽ����Ǯ��������");//1Ԫ�����Ǯ���㡣
						break;
					}else{						//20Ԫ��10Ԫ�����Ǯ����ʱ���������ת��Ϊ10��5Ԫ�����Ǯ
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
			for(j=0;j<all1.length;j++){		//�����Ӧ��������
				if(all1[j]!=0){
					System.out.print(all1[j]+"��"+s[j]+"  ");
				}
			}
			System.out.println(str0[1]+all+str0[2]+money+str0[3]);
		}
		  public int[] set(){			//������Ǯ
			 /* for(i=0;i<n0.length;i++){
					System.out.println("�������ʼ��"+s[i]+"��Ǯ������");
					Scanner sc = new Scanner(System.in);
					n0[i] = sc.nextInt();
				}*/
			  	n0[0]=n0[1]=n0[2]=n0[3]=n0[4]=100;
				System.out.println("������ɣ�");
				chaxun();
			  return n0;
		  }
		  public void chaxun(){			//��ѯ��Ǯ
			  for(int i=0;i<n0.length;i++){
					System.out.println("��ǰϵͳ�У�"+s[i]+n0[i]+"��");
				}
		  }
		

}

