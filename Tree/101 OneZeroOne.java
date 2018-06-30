package Leetcode;

public class OneZeroOne {

}
//recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        else return recurSymm(root.left, root.right);
    }
    boolean recurSymm(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a!=null && b!=null){
            if(a.val!=b.val) return false;
            return recurSymm(a.left, b.right) && recurSymm(a.right, b.left);
        }else{
            return false;
        }
    }
}
//ArrayDeque two

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null || root.left==null&&root.right==null) return true;
        if(root.left==null&&root.right!=null  || root.left!=null&&root.right==null) return false;
        TreeNode cur1=root.left, cur2=root.right;
        ArrayDeque<TreeNode> queue1=new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> queue2=new ArrayDeque<TreeNode>();
        queue1.add(cur1);
        queue2.add(cur2);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            if(queue1.size()!=queue2.size()) return false;
            int len=queue1.size();
            for(int i=0; i<len; i++){
                cur1=queue1.poll();
                cur2=queue2.poll();
                if(cur1.val!=cur2.val) return false;
                if(cur1.left!=null && cur2.right==null || cur1.left==null && cur2.right!=null) 
                    return false;
                if(cur1.right!=null&& cur2.left==null || cur1.right==null && cur2.left!=null)
                    return false;
                if(cur1.left!=null && cur2.right!=null){
                    queue1.add(cur1.left);
                    queue2.add(cur2.right);
                }
                if(cur1.right!=null && cur2.left!=null){
                    queue1.add(cur1.right);
                    queue2.add(cur2.left);
                }
            }
        }
        if(queue1.size()!=queue2.size()) return false;
        return true;
    }
}
