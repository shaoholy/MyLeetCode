package Leetcode;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;

public class TwoNineEight {

}
//recursion with class field int max; 
public class Solution {
    private int max = 0;
	public int longestConsecutive(TreeNode root) {
		if(root==null) return 0;
		max=1;
		recur298(root.left, root.val, 1);
		recur298(root.right, root.val, 1);
		return max;
	}
	private void recur298(TreeNode node, int lastval, int curlen) {
		max=Math.max(curlen, max);
		if(node==null) {
			return;
		}
		if (node.val==lastval+1) {
			curlen++;
			max++;
		}else {
			curlen=1;
		}
		recur298(node.left, node.val, curlen);
		recur298(node.right, node.val, curlen);
	}
}
