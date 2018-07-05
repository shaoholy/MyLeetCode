package Leetcode;

public class OneOneSeven {

}

/// iteration over level, O(n) time, O(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return; 
        root.next=null;
        TreeLinkNode cur=root, pre=null, iteNode=root;
        while(cur!=null){
            if(pre==null && (cur.left!=null || cur.right!=null)) pre=cur;
            
            if(cur.left!=null){
                if(cur.right!=null) cur.left.next=cur.right;
                else{
                    iteNode=cur;
                    while(iteNode.next!=null && (iteNode.next.left==null && iteNode.next.right==null)){
                        iteNode=iteNode.next;
                    }
                    cur.left.next= iteNode.next==null? null:
                        iteNode.next.left==null? iteNode.next.right:iteNode.next.left;
                    cur=iteNode;
                }
            }
            if(cur.right!=null){
                iteNode=cur;
                while(iteNode.next!=null && (iteNode.next.left==null && iteNode.next.right==null)){
                        iteNode=iteNode.next;
                }
                cur.right.next= iteNode.next==null? null:
                    iteNode.next.left==null? iteNode.next.right:iteNode.next.left;
                cur=iteNode;
            }
            
            
            cur=cur.next;
            if(cur==null){
                if(pre==null) cur=pre;
                else if(pre.left!=null) cur=pre.left;
                else cur=pre.right;
                pre=null;
            }
        }
    }
}

// simplify from above
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null && root.right==null) return; 
        root.next=null;
        TreeLinkNode cur=root, pre=null, iteNode, thisnode;
        while(cur!=null){
            if(pre==null && (cur.left!=null || cur.right!=null)) pre=cur;
            
            if(cur.left==null && cur.right==null) {
                cur=cur.next;
                continue;
            }
            if(cur.right!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                thisnode=cur.right;
            }else thisnode=cur.left;
            iteNode=cur;
            while(iteNode.next!=null && (iteNode.next.left==null && iteNode.next.right==null)){
                        iteNode=iteNode.next;
            }
            thisnode.next= iteNode.next==null? null:
                    iteNode.next.left==null? iteNode.next.right:iteNode.next.left;
            cur=iteNode.next;
            if(cur==null && pre!=null){
                cur= pre.left!=null? pre.left:pre.right;
                pre=null;
            }
        }
    }
}
//recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null && root.right==null) return; 
        root.next=null;
        dfs117(root);
    }
    void dfs117(TreeLinkNode node){
        //if(node==null) return;
        if(node.left==null && node.right==null) return;
        if(node.left!=null){
            if(node.right!=null){
                node.left.next=node.right;
                node.right.next=getFirstChild(node.next);
            }else{
                node.left.next=getFirstChild(node.next);
            }
        }else{
            node.right.next=getFirstChild(node.next);
        }
        if(node.right!=null) dfs117(node.right);
        if(node.left!=null) dfs117(node.left);
    }
    TreeLinkNode getFirstChild(TreeLinkNode node){
        if(node==null) return null;
        if(node.left!=null) return node.left;
        else if(node.right!=null) return node.right;
        else return getFirstChild(node.next);
    }
}

// same iteration logic, elegant code
public class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}