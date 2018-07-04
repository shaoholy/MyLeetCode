package Leetcode;

public class OneZeroSix {

}
///recursion, postorder backward, right to left, same as 105;
class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        return dfs106(postorder, inorder, 0, postorder.length);
    }
    TreeNode dfs106(int[] postorder, int[] inorder,int start, int end){
        if(index<0 || end-start==0) return null;
        int j=start;
        for(; j<end; j++){
                if(inorder[j]==postorder[index]) break;}
        TreeNode newnode=new TreeNode(postorder[index]);
        --index;
        newnode.right=dfs106(postorder, inorder, j+1, end);
        newnode.left=dfs106(postorder, inorder, start, j);
        return newnode;
    }
}