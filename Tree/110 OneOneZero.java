package Leetcode;

public class OneOneZero {

}
// recursion with getdepth method
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null || root.right==null && root.left==null ||
          root.left==null && root.right.left ==null && root.right.right==null || 
          root.right==null && root.left.left==null && root.left.right==null) return true;
        else{
            if(Math.abs(getdepth(root.left,1)-getdepth(root.right,1))>1) return false;
            else return isBalanced(root.left) && isBalanced(root.right);
        }
        
    }
    private int getdepth(TreeNode node, int cur){
        if(node==null) return cur;
        if(node.left==null && node.right==null) return cur+1;
        else{
            return Math.max(getdepth(node.left, cur+1), getdepth(node.right, cur+1));
        }
    }
}
// stack BFS level order trav

class Solution {
    public boolean isBalanced(TreeNode root) {
        Queue<TreeNode> nodeq=new LinkedList<TreeNode>();
        if(root==null) return true;
        nodeq.add(root);
        while(nodeq.size()!=0){
            int len=nodeq.size();
            for(int i=0; i<len; i++){
                TreeNode cur=nodeq.poll();
                if(Math.abs(getdepth(cur.left,1)-getdepth(cur.right,1))>1) return false;
                if(cur.left!=null) nodeq.add(cur.left);
                if(cur.right!=null) nodeq.add(cur.right);
            }
        }
        return true;
    }
    private int getdepth(TreeNode node, int cur){
        if(node==null) return cur;
        if(node.left==null && node.right==null) return cur+1;
        else{
            return Math.max(getdepth(node.left, cur+1), getdepth(node.right, cur+1));
        }
    }
}

// recu o(n)with max depth method

class Solution {
    private boolean res=true;
    public boolean isBalanced(TreeNode root) {
        int dep=maxdepth(root);
        return res;
    }
    private int maxdepth(TreeNode node){
        if(node==null) return 0;
        int leftdepth=maxdepth(node.left);
        int rightdepth=maxdepth(node.right);
        if(Math.abs(leftdepth-rightdepth)>1) res=false;
        return 1+Math.max(leftdepth, rightdepth);
    }
}