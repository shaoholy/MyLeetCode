package Leetcode;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class OneOneThree {

}
//recur
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res=new ArrayList<List<Integer>>();
      List<Integer> cur=new ArrayList<Integer>();
      if(root==null) return res;
      dfsPS(root, sum, cur, res);
      return res;
  }
  private void dfsPS(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res){
      if(node.left==null && node.right==null){
          int cursum=0;
		    for(int x: cur) cursum+=x;
		    if(cursum+node.val==sum) {
			List<Integer> toadd=new ArrayList<Integer>();
			for(int x: cur) toadd.add(x);
              toadd.add(node.val);
			res.add(toadd);
		}
      }
      if(node.left!=null){
          cur.add(node.val);
          dfsPS(node.left, sum, cur, res);
          cur.remove(cur.size()-1);
      }
      if(node.right!=null){
          cur.add(node.val);
          dfsPS(node.right, sum, cur, res);
          cur.remove(cur.size()-1);
      }
  }
}

//LinkedList BFS
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res=new ArrayList<List<Integer>>();
      //List<Integer> cur=new ArrayList<Integer>();
      if(root==null) return res;
      Queue<TreeNode> nodeq=new LinkedList<TreeNode>();
      Queue<List<Integer>> listq=new LinkedList<List<Integer>>();
      nodeq.add(root);
      List<Integer> newlist=new LinkedList<Integer>();
      listq.add(newlist);
      while(nodeq.size()!=0){
          int len=nodeq.size();
          for(int i=0; i<len; i++){
              TreeNode cur=nodeq.poll();
              List<Integer> curlist=listq.poll();
              if(cur.left==null && cur.right==null){
                  int cursum=0;
                  for(int x: curlist) cursum+=x;
                  if(cursum+cur.val==sum){
                      curlist.add(cur.val);
                      res.add(curlist);
                  }
              }
              if(cur.left!=null){
                  List<Integer> newlist1=new LinkedList<Integer>();
                  for(int x: curlist) newlist1.add(x);
                  newlist1.add(cur.val);
                  listq.add(newlist1);
                  nodeq.add(cur.left);
              }
              if(cur.right!=null){
                  List<Integer> newlist2=new LinkedList<Integer>();
                  for(int x: curlist) newlist2.add(x);
                  newlist2.add(cur.val);
                  listq.add(newlist2);
                  nodeq.add(cur.right);
              }
          }
      }
      
      return res;
  
  }
}
//dfs stack
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res=new ArrayList<List<Integer>>();
      if(root==null) return res;
      Stack<TreeNode> nodestack=new Stack<TreeNode>();
      Stack<List<Integer>> liststack=new Stack<List<Integer>>();
      nodestack.push(root);
      liststack.push(new LinkedList<Integer>());
      while(nodestack.size()!=0){
          int len=nodestack.size();
          for(int i=0; i<len; i++){
              TreeNode cur=nodestack.pop();
              List<Integer> curlist=liststack.pop();
              if(cur.left==null && cur.right==null){
                  int cursum=0;
                  for(int x: curlist) cursum+=x;
                  if(cursum+cur.val==sum){
                      curlist.add(cur.val);
                      res.add(curlist);
                  }
              }
              if(cur.left!=null){
                  List<Integer> newlist1=new LinkedList<Integer>();
                  for(int x: curlist) newlist1.add(x);
                  newlist1.add(cur.val);
                  liststack.push(newlist1);
                  nodestack.push(cur.left);
              }
              if(cur.right!=null){
                  List<Integer> newlist2=new LinkedList<Integer>();
                  for(int x: curlist) newlist2.add(x);
                  newlist2.add(cur.val);
                  liststack.push(newlist2);
                  nodestack.push(cur.right);
              }
          }
      }
      return res;
  }
}