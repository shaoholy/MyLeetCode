package Leetcode;

public class OneOneSix {

}
//recursion o(n) time, o(h) space;

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        root.next=null;
        dfs116(root);
    }
    private void dfs116(TreeLinkNode node){
        if(node.left==null && node.right==null) return;
        node.left.next=node.right;
        if(node.next!=null) node.right.next=node.next.left;
        else node.right.next=null;
        dfs116(node.right);
        dfs116(node.left);
    }
}

//level order trav, o(n) time o(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur=root, pre=root; 
        while(cur!=null){
            if(cur.left!=null){
            cur.left.next=cur.right;
            if(cur.next!=null) {
                cur.right.next=cur.next.left;
            }else cur.right.next=null;
            }
            cur=cur.next;
            if(cur==null){
                cur=pre.left;
                pre=cur;
            }
        }
    }
}
