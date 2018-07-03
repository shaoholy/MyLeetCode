package Leetcode;

public class OneZeroThree {

}
//BFS with boolean flag (switch add/add(0,))
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> nodeq=new LinkedList<TreeNode>();
        nodeq.add(root);
        boolean flag=true;
        while(nodeq.size()!=0){
            int len=nodeq.size();
            res.add(new ArrayList<Integer>());
            for(int i=0; i<len; i++){
                TreeNode cur=nodeq.poll();
                if(flag) res.get(res.size()-1).add(cur.val);
                else res.get(res.size()-1).add(0, cur.val);
                 if(cur.left!=null) nodeq.add(cur.left);
                 if(cur.right!=null) nodeq.add(cur.right);
            }
            flag=!flag;
        }
        return res;
    }
}
//dfs with recursion, int level as parameter and level%2 to judge forward/backward
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        dfsZZLO(root, res, 0);
        return res;
    }
    private void dfsZZLO(TreeNode node, LinkedList<List<Integer>> res, int level){
        if(node==null) return;
        if(level>=res.size()) res.add(new ArrayList<Integer>());
        if(node.left!=null) dfsZZLO(node.left, res, level+1);
        if(node.right!=null) dfsZZLO(node.right,res, level+1);
        if(level%2==0)res.get(level).add(node.val);
        else res.get(level).add(0,node.val);
    }
}
