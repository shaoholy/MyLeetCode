ckage Leetcode;

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

//recursion thinking iteration with addFirst

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> NodeStack=new Stack<TreeNode>();
        LinkedList<Integer> res=new LinkedList<Integer>();
        TreeNode cur=root;
        NodeStack.push(root);
        while(!NodeStack.empty()) {
        		cur=NodeStack.pop();
        		res.addFirst(cur.val);
        		if(cur.left!=null) NodeStack.push(cur.left);
        		if(cur.right!=null) NodeStack.push(cur.right);
        }
        return res;
    }
}

//one stack iteration

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> NodeStack=new Stack<TreeNode>();
        LinkedList<Integer> res=new LinkedList<Integer>();
        TreeNode cur=root;
        
        while(cur!=null||!NodeStack.isEmpty()){
            while(cur!=null) {
                NodeStack.push(cur);
                cur=cur.left;
            }
            if(NodeStack.peek().right!=null){
                cur=NodeStack.peek().right;
            }else{
                cur=NodeStack.pop();
                res.add(cur.val);
                while(!NodeStack.empty() && NodeStack.peek().right==cur){
                    cur=NodeStack.pop();
                    res.add(cur.val);
                }
                if(NodeStack.empty()) break;
                cur=NodeStack.peek().right;
            }
        }
        return res;
    }
}
//concise one stack post travesal
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res=new LinkedList<>();
    Stack<TreeNode> nodestack=new Stack<>();
    TreeNode cur=null;
    expand(nodestack, root);
    while(!nodestack.empty()) {
    		if(nodestack.peek().right==null || cur==nodestack.peek().right) {
    			cur=nodestack.pop();
                res.add(cur.val);
    		}else {
    			expand(nodestack, nodestack.peek().right);
    		}
        }
        return res;
    }
    private void expand(Stack<TreeNode> nodestack, TreeNode node){  
        while(node!=null) {
                nodestack.push(node);
                node=node.left;
        }
    }
}

