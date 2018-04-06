package tree;

import java.math.BigInteger;
import java.util.ArrayList;





public class SumLeafpath {

	public static void main(String[] args) {

	}

	public int sumNumbers(TreeNode a) {
		if(a == null) {
			return 0;
		}
		ArrayList<String> list =  new ArrayList<>();
		getLeafvalues(a, "",list);
		return sumAllNumbers(list);
	}

	private int sumAllNumbers(ArrayList<String> list) {
		BigInteger sum = new BigInteger("0");
		BigInteger divisor = new BigInteger("10003");
		for(int i = 0 ; i < list.size(); i++) {
			BigInteger num = new BigInteger(list.get(i));
			sum = sum.add(num.mod(divisor));
		}
		return sum.mod(divisor).intValue();
	}
	

	private void getLeafvalues(TreeNode a, String num, ArrayList<String> list) {
		if(a == null) {
			return;
		}
		num = num + a.val;
		if(a.left == null && a.right == null) {
			list.add(num);
		}
		getLeafvalues(a.left, num, list);
		getLeafvalues(a.right, num, list);
	}
}
