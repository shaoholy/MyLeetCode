package Leetcode;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;

public class TwoNineEight {

}
//recursion with class field int max; up to down
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

//1, divide Conquer O(N) time, O(h) space
public class Solution {
  int max;

  public int longestConsecutive(TreeNode root) {
    max = 0;
    dfs(root);
    return max;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftRes = dfs(node.left);
    int rightRes = dfs(node.right);

    int leftP = (leftRes == 0 || node.val != node.left.val - 1) ? 1 : 1 + leftRes;
    int rightP = (rightRes == 0 || node.val != node.right.val - 1) ? 1 : 1 + rightRes;
    int res = Math.max(leftP, rightP);
    max = Math.max(max, res);
    return res;
  }
}

