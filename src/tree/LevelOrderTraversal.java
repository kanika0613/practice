package tree;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class LevelOrderTraversal {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		List<Integer> list = new ArrayList<>();
		return verticalOrderUtil(A, list);
	}

	private ArrayList<ArrayList<Integer>> verticalOrderUtil(TreeNode a, List<Integer> list) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		if(a == null) {
			return null;
		} 

			return result;
	}
}
