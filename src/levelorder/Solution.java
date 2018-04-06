package levelorder;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode A) {
		if(A == null) {
			return null;
		}
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(A);
		result.add(list);
		
		levelOrderUtil(result, list);
		return result;
	}

	private void levelOrderUtil(ArrayList<ArrayList<TreeNode>> result, ArrayList<TreeNode> prev) {
		if(prev == null || prev.size() == 0) {
			return;
		}
		ArrayList<TreeNode> list = new ArrayList<>();
		
		for (int index=0; index< prev.size(); index++) {
			TreeNode node = prev.get(index);
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}
		}
		result.add(list);
		levelOrderUtil(result, list);
	}

	private int getHeight(TreeNode a) {
		if(a == null) {
			return 0;
		}
		return Math.max(getHeight(a.left),getHeight(a.right)) + 1;
	}


	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node9;
		node3.left = node4;
		node3.right = node5;
		node4.left = node6;
		node5.right = node7;
		
		
		Solution sol = new Solution();
		ArrayList<ArrayList<TreeNode>> res = sol.levelOrderTraversal(node1);
		for(int j = 0; j < res.size(); j++) {
			for(int index = 0; index < res.get(j).size();index++) {
				System.out.print(res.get(j).get(index).val + " ");
			}
		System.out.println();
		}
	}
}