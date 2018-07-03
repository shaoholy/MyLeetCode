package Leetcode;

public class OneOneFour {

}
//Inorder traversal with right-node-Stack
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> nodeq=new Stack<TreeNode>();
        LinkedList<TreeNode> newq=new LinkedList<TreeNode>();
        TreeNode cur=root;
        while(cur!=null || nodeq.size()!=0){
            newq.add(cur);
            if(cur.right!=null) nodeq.push(cur.right);
            if(cur.left!=null) cur=cur.left;
            else if(nodeq.size()!=0) cur=nodeq.pop();
            else break;
        }
        while(newq.size()!=0){
            cur=newq.poll();
            cur.left=null;
            if(newq.size()!=0) cur.right=newq.peek();
            else {cur.right=null;
                  break;}
        }
    }
}

//recursion 

class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null) flatten(root.right);
        else {
            TreeNode preright=root.right, mover=root.left, moverend=mover;
            while(moverend.right!=null) moverend=moverend.right;
            root.right=root.left;
            root.left=null;
            moverend.right=preright;
            flatten(root.right);
        }
    }
}
//same logic , no recur
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        while(root.right!=null || root.left!=null) {
        		if(root.left!=null) {
        			 TreeNode preright=root.right,  moverend=root.left;
                 while(moverend.right!=null) moverend=moverend.right;
                 root.right=root.left;
                 root.left=null;
                 moverend.right=preright;
        		}
        		root=root.right;
        }
    }
}

//concise recursion with backward inorder thinking

class Solution {
	private TreeNode prev=null
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}