package Leetcode;

public class OneZeroFour {

}
//recur
class Solution {
    public int maxDepth(TreeNode root) {
        return getMD(root,0);
    }
    private int getMD(TreeNode thenode, int depth){
        if(thenode==null) return depth;
        return Math.max(getMD(thenode.left, depth+1),getMD(thenode.right,depth+1));
    }
}

//LinkedList leveltraversal BFS
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> nodeq=new LinkedList<TreeNode>();
        if(root==null) return 0;
        TreeNode cur=root;
        nodeq.add(root);
        int depth=0;
        while(nodeq.size()!=0){
            int len=nodeq.size();
            for(int i=0; i<len; i++){
                cur=nodeq.poll();
                if(cur.left!=null) nodeq.add(cur.left);
                if(cur.right!=null) nodeq.add(cur.right);
            }
            depth++;
        }
        return depth;
    }
}