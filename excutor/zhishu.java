package org.excutor;

import java.util.ArrayList;

public class zhishu {
	
	public static void main(String[] args) {
		excuter ec = new excuter();
		ArrayList<Integer> al = ec.zhishu(100);
//		for(Integer i : al) {
//			if(i!=al.get(al.size()-1)) {
//				System.out.print(i+",");
//			}else {
//				System.out.println(i);
//			}
//		}
		
		
	}

}

class excuter {
	ArrayList<Integer> al = new ArrayList<Integer>();
	public ArrayList<Integer> zhishu(int num) {
		al.add(new Integer(2));
		boolean flag;
		for(int i=2;i<num+1;i++) {
			flag = true;
			for(Integer j :al) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				al.add(new Integer(i));
			}
		}
		return al;
	}
	
    public int removeDuplicates(int[] nums) {
        int flag,index=0;
        int[] num = new int[nums.length];
    	for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) {
            	
            }
        }
        return 0;
    }
}
