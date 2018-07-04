package Leetcode;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

//dfs, o(n) time, o(h) space
public class ThreeThreeThree {
	int max;
	public int get333(TreeNode root) {
		HashMap<TreeNode, range> lookupmap=new HashMap<TreeNode, range>();
		dfs333(root, lookupmap);
		max=0;
		return max;
	}
	private int dfs333(TreeNode node, HashMap<TreeNode, range> lookupmap) {
		
		int res=0;
		if(node==null) return res;
		int leftmax=dfs333(node.left);
		int rightmax=dfs333(node.right);
		if((node.left==null || (lookupmap.containsKey(node.left) && lookupmap.get(node.left).max<node.val)) && 
		(node.right==null || lookupmap.containsKey(node.right) && lookupmap.get(node.right).min>node.val) ){
			res=1+leftmax+rightmax;
			int mi= node.left==null? node.val: lookupmap.get(node.left).min;
			int ma= node.right==null? node.val: lookupmap.get(node.right).max;
			lookupmap.put(node, new range(ma, mi));
		}
		else {
			res=0;
		}
		max=Math.max(res, max);
		return res;
	}
}
class range{
	int max;
	int min;
	public range(int max, int min) {
		this.max=max;
		this.min=min;
	}
}


