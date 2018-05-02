package org.excutor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class InsertSort {
	
	public static int[] insertSort(int[] arr){
		int tmp = 0;
		if(arr == null) return null;
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int tem = 0;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		Random random = new Random();
//		while(hashSet.size()<30) {
//			tem = random.nextInt(30);
//			System.out.println("g : "+tem);
//			hashSet.add(tem);
//		}
		while(arrayList.size()<10) {
			tem = random.nextInt(10);
			if(!arrayList.contains(tem)) {
				arrayList.add(tem);
			}
		}
		for(int a:arrayList) {
			System.out.print(a+" ");
		}
		System.out.println();
		 int[] arr = new int[arrayList.size()];
		 for(int i=0;i<arrayList.size();i++) {
			 arr[i] = (int)arrayList.get(i);
		 }
		 int[] insertSort = insertSort(arr);
		 for(int i:insertSort) {
			 System.out.print(i+" ");
		 }
		
	}

}
