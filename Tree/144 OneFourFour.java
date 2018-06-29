package Leetcode;

public class OneFourFour {

}
//recur
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        recurpreorder(root,res);
        return res;
    }
    void recurpreorder(TreeNode cur, List<Integer> res){
        if(cur==null) return;
        res.add(cur.val);
        recurpreorder(cur.left, res);
        recurpreorder(cur.right, res);
    }
}

//stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodestack=new Stack<TreeNode>();
        List<Integer> res=new LinkedList<Integer>();
        TreeNode cur=root;
        while(cur!=null || !nodestack.empty()){
            if(cur==null){
                cur=nodestack.pop();
            }
            res.add(cur.val);
            if(cur.right!= null) nodestack.push(cur.right);
            cur=cur.left;
        }
        return res;
    }
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
		res.add(cur.val);
                    pre.right=cur;
                    cur=cur.left;
                }else{
                    pre.right=null;
                    
                    cur=cur.right;
                }
            }
        }
        return res;
    }
}
