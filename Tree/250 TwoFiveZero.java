
package Leetcode;

public class TwoFiveZero {

}

//recursion time O(N) space o(h)
private int unisub(TreeNode root) {
	if(root==null) return 0;
	if(root.left==null && root.right==null) return 1;
	else {
		int leftuni= unisub(root.left);
		int rightuni=  unisub(root.right);
		return root.left==null&&root.val==root.right.val || root.right==null&&root.val==root.left.val || 
				root.val==root.left.val&&root.val==root.right.val? 1+leftuni+rightuni :leftuni+rightuni;
	}
}
//
//recursion time O(N) space o(h)/o(logN)
 class Solution {
	 private int res;
     public int countUnivalSubtrees(TreeNode root) {
    	 	res=0;
    	 	dfs(root, res);
        return res;
     }
     
     private boolean dfs(TreeNode root){
         if(root == null){
             return true;
         }
         
         boolean left = dfs(root.left);
         boolean right = dfs(root.right);
         if(left && right){
             if(root.left!=null && root.left.val!=root.val){
                 return false;
             }
             
             if(root.right!=null && root.right.val!=root.val){
                 return false;
             }
             
             res++;
             return true;
         }
         
         return false;
     }
 }