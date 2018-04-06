package tree;

import java.util.LinkedList;


public class FlattenTree {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;
		node5.right = node6;
		FlattenTree sol = new FlattenTree();
		System.out.println(sol.flatten(node1));
		
	}
	public TreeNode flatten(TreeNode a) {
		if(a == null) {
			return null;
		}
		LinkedList<TreeNode> list  =  new LinkedList<>();
		getList(a, list);
		
		int index = 1;
		TreeNode root = new TreeNode(list.get(0).val);
		TreeNode root1 = root;
		while(index < list.size()) {
			root.right =  new TreeNode(list.get(index).val);
			root = root.right;
			index ++;
		}
		return root1;
	}
	private void getList(TreeNode a, LinkedList<TreeNode>list) {
		if(a == null) {
			return;
		}
		list.add(a);
		getList(a.left, list);
		getList(a.right, list);
	}
}