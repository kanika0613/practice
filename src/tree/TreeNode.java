package tree;
public class TreeNode {
	TreeNode root;
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	TreeNode(int value){
		this.val = value;
		this.left  = null;
		this.right = null;
	}
}
