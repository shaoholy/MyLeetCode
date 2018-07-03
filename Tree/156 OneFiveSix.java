package Leetcode;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class OneFiveSix {

}
//
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        TreeNode cur=root, newroot;
        LinkedList<TreeNode> branchnode=new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightnode=new LinkedList<TreeNode>();
        while(cur!=null) {
        		branchnode.add(cur);
        		rightnode.add(cur.right);
        		cur=cur.left;
        }
        newroot=branchnode.poll();
        cur=newroot;
        while(branchnode.size()!=0) {
        		cur.left=rightnode.poll();
        		cur.right=branchnode.poll();
        }
        return newroot;
    }
}
For example:
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5
 

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  
   
   //recursion 
   
   public class Solution {
	    public TreeNode upsideDownBinaryTree(TreeNode root) {
	        if (root == null || root.left == null && root.right == null)
	            return root;
	        TreeNode newRoot = upsideDownBinaryTree(root.left);
	        root.left.left = root.right;
	        root.left.right = root;

	        root.left = null;
	        root.right = null;

	        return newRoot;
	    }
	}
