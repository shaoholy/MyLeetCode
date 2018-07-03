package Leetcode;

import java.awt.List;

import javax.swing.tree.TreeNode;

public class OneNineNine {

}
//same as leveltravesal, use getLast() to add val of each level,o(n) time, o(n) space
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        ArrayDeque<TreeNode> nodeq=new ArrayDeque<TreeNode>();
        nodeq.add(root);
        while(nodeq.size()!=0){
            int len=nodeq.size();
            res.add(nodeq.getLast().val);
            for(int i=0; i<len; i++){
                TreeNode cur=nodeq.poll();
                if(cur.left!=null) nodeq.add(cur.left);
                if(cur.right!=null) nodeq.add(cur.right);
            }
        }
        return res;
    }
}

//dfs with recursion , int-level as parameter
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        dfspreorder(root, res, 0);
        return res;
    }
    private void dfspreorder(TreeNode node, List<Integer> res, int level) {
    		if(node==null) return;
    		if(level>=res.size()) res.add(node.val);
    		dfspreorder(node.right, res, level+1);
    		dfspreorder(node.left, res,level+1);
    }
}