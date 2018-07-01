package Leetcode;

public class OneOneOne {

}
//BFS LinkedList
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> levelq=new LinkedList<TreeNode>();
        levelq.add(root);
        int res=1;
        while(levelq.size()!=0){
            int len=levelq.size();
            for(int i=0; i<len; i++){
                TreeNode cur=levelq.poll();
                if(cur.left==null && cur.right==null) return res;
                if(cur.left!=null) levelq.add(cur.left);
                if(cur.right!=null) levelq.add(cur.right);
            }
            res++;
        }
        return res;
    }
}
//recur

class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        else{
            if(root.left==null && root.right!=null) return 1+minDepth(root.right);
            if(root.left!=null && root.right==null) return 1+minDepth(root.left);
            else return Math.min(1+minDepth(root.left),1+minDepth(root.right));
        }
    }
}