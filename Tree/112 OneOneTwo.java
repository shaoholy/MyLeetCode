package Leetcode;

public class OneOneTwo {

}
//recur
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
      if(root==null) return false;
      if(root.left==null && root.right==null) return sum==root.val; 
      return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
  }
}

//LinkedList BFS
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
      if(root==null) return false;
      Queue<Integer> sumq=new LinkedList<Integer>();
      Queue<TreeNode> nodeq=new LinkedList<TreeNode>();
      sumq.add(0);
      nodeq.add(root);
      while(nodeq.size()!=0){
          TreeNode curNode=nodeq.poll();
          int cursum=sumq.poll();
          if(curNode.right==null && curNode.left==null && cursum+curNode.val==sum) return true;
          if(curNode.left!=null){
              nodeq.add(curNode.left);
              sumq.add(cursum+curNode.val);
          }
          if(curNode.right!=null){
              nodeq.add(curNode.right);
              sumq.add(cursum+curNode.val);
          }
      }
      return false;
  }
}

//Stack DFS
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
      if(root==null) return false;
      Stack<Integer> sumstack=new Stack<Integer>();
      Stack<TreeNode> nodestack=new Stack<TreeNode>();
      sumstack.push(0);
      nodestack.push(root);
      while(!nodestack.empty()){
          TreeNode curNode=nodestack.pop();
          int cursum=sumstack.pop();
          if(curNode.right==null && curNode.left==null && cursum+curNode.val==sum) return true;
          if(curNode.left!=null){
              nodestack.push(curNode.left);
              sumstack.push(cursum+curNode.val);
          }
          if(curNode.right!=null){
              nodestack.push(curNode.right);
              sumstack.push(cursum+curNode.val);
          }
      }
      return false;
  }
}