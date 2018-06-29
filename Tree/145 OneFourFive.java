package Leetcode;

public class OneFourFive {

}
//recur
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        recurpostorder(root, res);
        return res;
    }
    void recurpostorder(TreeNode cur, List<Integer> res){
        if(cur==null) return;
        recurpostorder(cur.left, res);
        recurpostorder(cur.right, res);
        res.add(cur.val);
    }
}

//two stack from right to left, then pop to list
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> NodeStack=new Stack<TreeNode>();
        Stack<TreeNode> leftnodes=new Stack<TreeNode>();
        LinkedList<Integer> res=new LinkedList<Integer>();
        TreeNode cur=root;
        while(cur!=null || !leftnodes.empty()){
            if(cur==null){
                cur=leftnodes.pop();
            }
            if(cur!=null){
                if(cur.left!=null) leftnodes.push(cur.left);
                NodeStack.push(cur);
                cur=cur.right;
            }
        }
        while(!NodeStack.empty()){
            res.add(NodeStack.pop().val);
        }
        return res;
    }
}

//