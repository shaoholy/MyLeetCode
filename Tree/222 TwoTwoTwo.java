package Leetcode;

public class TwoTwoTwo {

}
//recursion, zhongdian: right/left's left depth same or not.
class Solution {
    public int countNodes(TreeNode root) {
        int height=depth(root);
        if(height==-1) return 0;
        return depth(root.left)==depth(root.right)? (1<<height)+countNodes(root.right):(1<<height-1)+countNodes(root.left);
    }
    private int depth(TreeNode node){
        if(node==null) return -1;
        else return 1+depth(node.left);
    }
}

//divide and conquer
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        if(leftdepth(root)==rightdepth(root)) return (1<<(leftdepth(root)+1))-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int leftdepth(TreeNode node){
        if(node==null) return -1;
        else return 1+leftdepth(node.left);
    }
    private int rightdepth(TreeNode node){
        if(node==null) return -1;
        else return 1+rightdepth(node.right);
    }
}