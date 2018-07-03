package Leetcode;

public class OneZeroSeven {

}
//bfs initiate no generic. (if conflict, use only method from object itself, instead of from the generic data type, because of method loss.) 
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> nodeq=new LinkedList<TreeNode>();
        nodeq.add(root);
        while(nodeq.size()!=0){
            int len=nodeq.size();
            res.addFirst(new ArrayList<Integer>());
            for(int i=0; i<len; i++){
                TreeNode cur=nodeq.poll();
                res.get(0).add(cur.val);
                if(cur.left!=null) nodeq.add(cur.left);
                if(cur.right!=null) nodeq.add(cur.right);
            }
        }
        return res;
    }
}
// DFS without recursion, create a class with node and level-int;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null) return res;
        Stack<nodepair> nodestack=new Stack<nodepair>();
        nodestack.push(new nodepair(root, 0));
        while(!nodestack.empty()){
            nodepair cur=nodestack.pop();
            if(cur.level+1>res.size()) res.addFirst(new ArrayList<Integer>());
            res.get(res.size()-cur.level-1).add(cur.node.val);
            if(cur.node.right!=null) nodestack.push(new nodepair(cur.node.right, cur.level+1));
            if(cur.node.left!=null) nodestack.push(new nodepair(cur.node.left, cur.level+1));
        }
        return res;
    }
}
class nodepair{
    int level;
    TreeNode node;
    public nodepair(TreeNode node, int level){
        this.node=node;
        this.level=level;
    }
}

//dfs with recursion, level pass as input;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        dfsLOT(root, res, 0);
        return res;
    }
    private void dfsLOT(TreeNode node, LinkedList<List<Integer>> res, int level){
        if(node==null) return;
        if(level+1>res.size()) res.addFirst(new ArrayList<Integer>());
        if(node.left!=null) dfsLOT(node.left, res, level+1);
        if(node.right!=null) dfsLOT(node.right,res, level+1);
        res.get(res.size()-level-1).add(node.val);
    }
}