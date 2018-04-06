package twoSumBinary;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		ArrayList<Integer> input =  new ArrayList<>();
		input.add(7);
		input.add(14);
		input.add(20);
		input.add(1);
		System.out.println(checkList2Sum(21,input));
	
	}

	 /*public static int t2Sum(TreeNode A, int B) {
		 if(A == null || B == 0){
			 return 0;
		 } 
		 ArrayList<Integer> inputList = new ArrayList<Integer>();
		 sendtoList(A, inputList);
		 return checkList2Sum(B, inputList);
	 }*/
	private static int checkList2Sum(int b, ArrayList<Integer> list) {
		if(list.isEmpty()){
			return 0;
		}
		for(int first = 0; first <= list.size() - 1; first++){
		        if(list.contains(b - list.get(first)) && (list.indexOf(b - list.get(first)) != first)){
				    return 1;
	            }
		}
		return 0;
	}
	/*private static void sendtoList(TreeNode a, ArrayList<Integer> list) {
		if(a == null){
			return;
		}
		list.add(a.value);
		if(a.left != null){
			sendtoList(a.left, list);
		}
		if(a.right != null){
			sendtoList(a.right, list);
		}
	}*/
	
}
