package Leetcode;

public class NineFour {

}

//1 recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        getinorder(root, res);
        return res;
    }
    private void getinorder(TreeNode node, List<Integer> res){
        if(node==null) return;
        getinorder(node.left, res);
        res.add(node.val);
        getinorder(node.right, res);
        return;  
    }
}

//Two Stack

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<Integer> thestack = new Stack<Integer>();
        Stack<TreeNode> NodeStack= new Stack<TreeNode>();
        List<Integer> res=new LinkedList<Integer>();
        if(root==null) return res;
        TreeNode curr=root;
        do{
                if(curr==null){
                    curr=NodeStack.pop();
                    res.add(thestack.pop());
                    }
                if(curr!=null){
                    thestack.push(curr.val);
                    NodeStack.push(curr.right);
                    curr=curr.left;
                    }
            }while(!thestack.empty() && !NodeStack.empty());
        return res;
    }
}

//one stack

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}

//morris

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        if(root==null) return res;
        TreeNode cur=root, pre=null;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur=cur.right;
            }else{
                pre=cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }else{
                    pre.right=null;
                    res.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return res;
    }
}