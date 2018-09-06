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
//recur 
public class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length; 
        if(inorder == null || inorder.length == 0){
            return null; 
        }
        
        
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd){
        
        int curVal = postorder[pEnd];
        TreeNode node = new TreeNode(curVal);
        int inIdx = -1, pIdx = pEnd;
        for(int i = inStart; i <= inEnd; i++){
            if(curVal == inorder[i]){
                inIdx = i;
                break;
            }
        }
        
        if(inIdx == inEnd){
            node.right = null; 
        }else{
        //if right exists
            pIdx = pEnd - (inEnd - inIdx);
            node.right = buildTree(inorder, inIdx + 1, inEnd, postorder, pIdx, pEnd - 1);
        }
        
        node.left = inIdx == inStart? null : buildTree(inorder, inStart, inIdx - 1, postorder, pStart, pIdx - 1);
        return node; 
    }
}