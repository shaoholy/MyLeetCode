package Leetcode;

import javax.swing.tree.TreeNode;

//dfs, o(n) time, o(h) space
public class ThreeThreeThree {
	int max;
	public int get333(TreeNode root) {
		dfs333(root);
		max=0;
		return max;
	}
	private int dfs333(TreeNode node) {
		
		int res=0;
		if(node==null) return res;
		int leftmax=dfs333(node.left);
		int rightmax=dfs333(node.right);
		if(node.left==null || node.left.val<node.val && 
		node.right==null || node.right>node.val) {
			res=1+leftmax+rightmax;
		}
		else {
			res=0;
		}
		max=Math.max(res, max);
		return res;
	}
}


