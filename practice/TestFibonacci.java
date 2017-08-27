package practice;

public class TestFibonacci {
	int a = 1, b = 1, c = 0;
	public int TestFibonacci(int num){
		//if(num<1) return 0;
		if(num==1) return a;
		if(num==2) return b;
		return TestFibonacci(num-1)+TestFibonacci(num-2);
		
	}
	public int[] TestYHTriangle(int num){
		//System.out.println("test!");
		if(num<1) return null;
		int[] line = new int[num];
		line[0] = 1;
		line[num-1]=1;
		int[] oldLine = TestYHTriangle(num-1);
		if(oldLine != null){
			for(int i = 1; i < num-1;i++){
				line[i] = oldLine[i-1]+oldLine[i];
			}
		}
		return line;
	}
	public static void main(String[] args) {  
		int testNum = 10;
		TestFibonacci tf = new TestFibonacci();
		//斐波纳契数列
		//for(int i = 1;i < testNum;i++){
			//System.out.print(tf.TestFibonacci(i));
		//	System.out.print("\t");
		//}
		//杨辉三角
		for(int j = 1;j < testNum + 1; j++){
			int[] testArray = tf.TestYHTriangle(j);
			for(int l = testNum-j;l > 0;l--){
				System.out.print("\t");
			}
			for(int k = 0;k < testArray.length; k++){
				System.out.print(testArray[k]+"\t\t");
			}
			System.out.println();
		}
	}  
}
