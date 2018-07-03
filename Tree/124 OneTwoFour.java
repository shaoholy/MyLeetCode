package Leetcode;

public class OneTwoFour {

}

//recursion. zhongdian: each node itself max and its return is not same, must consider not included condition
class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        int x=dfsmaxPS(root);
        return max;
    }
    public int dfsmaxPS(TreeNode root){
        int res;
        if(root==null) res= 0;
        else {
            int leftmax=dfsmaxPS(root.left);
            int rightmax=dfsmaxPS(root.right);
            res= root.val+Math.max(leftmax, rightmax)>0? root.val+Math.max(leftmax,rightmax):0;
            max=Math.max(root.val+leftmax+rightmax,max);}
        return res;
    }
}