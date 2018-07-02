package Leetcode;

import java.awt.List;
import java.util.LinkedList;
import java.util.regex.Matcher;

import javax.swing.tree.TreeNode;

public class ThreeSixSix {

}
//use queue as recur method
public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root==null) return res;
    TreeNode cur=root;
    LinkedList<TreeNode> nodeq=new LinkedList<TreeNode>();
    List<Integer> newlist;
    while(root!=null) {
    		nodeq.add(root);
    		newlist=new LinkedList<Integer>();
    		while(nodeq.size()!=0) {
    			cur=nodeq.poll();
    			if(cur.left==null && cur.right==null) {
    				newlist.add(cur.val);
    				root=null;
    				break;
    			}
    			if(cur.left!=null) {
    				if(cur.left.left==null && cur.left.right==null) {
    					newlist.add(cur.left.val);
    					cur.left=null;
    				}else {
    					nodeq.add(cur.left);
    				}
    			}
    			if(cur.right!=null) {
    				if(cur.right.left==null && cur.right.right==null) {
    					newlist.add(cur.right.val);
    					cur.right=null;
    				}else {
    					nodeq.add(cur.right);
    				}
    			}
    		}
    		res.add(newlist);
    }
    return res;
}
//private void dfs366(TreeNode root, List<List<Integer>> res, int depth) {
//	if(root.right==null && root.left==null) {
//		List<Integer> newlist=new ArrayList<Integer>();
//		newlist.add(root.val);
//		res.add(newlist);
//		root=null;
//		return;
//	}
//}

// recur with height as list index
public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
}
private int getdepth(TreeNode node, List<List<Integer>> res) {
	if(node==null) return -1;
	int result= Math.max(getdepth(node.left), getdepth(node.right))+1;
	if(result>res.size()-1) res.add(new LinkedList<Integer>);
	res.get(result).add(node.val);
	return result;
}
