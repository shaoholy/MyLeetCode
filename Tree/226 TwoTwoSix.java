package Leetcode;

public class TwoTwoSix {

}
//Stack DFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> thestack=new Stack<TreeNode>();
        if(root==null || root.left==null&&root.right==null) return root;
        TreeNode cur; 
        thestack.push(root);
        while(!thestack.empty()){
            cur=thestack.pop();
            TreeNode temp=cur.left;
            cur.left=cur.right;
            cur.right=temp;
            if(cur.left!=null) thestack.push(cur.left);
            if(cur.right!=null) thestack.push(cur.right);
        }
        return root;
    }
}

// recursion
class Solution {
    public TreeNode invertTree(TreeNode root) {
        recurInvert(root);
        return root;
    }
    void recurInvert(TreeNode node){
        if(node==null) return;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        recurInvert(node.left);
        recurInvert(node.right);
        
    }
}