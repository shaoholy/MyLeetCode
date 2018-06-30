package Leetcode;

public class TwoFiveSeven {

}
//recur
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        String curStr="";
        List<String> res= new ArrayList<String>();
        if(root==null) return res;
        dfsBTP(curStr, res, root);
        return res;
    }
    void dfsBTP(String curStr, List<String> res, TreeNode node){
        if(node.left==null && node.right==null){
            curStr=curStr+"->"+node.val;
            curStr=curStr.substring(2);
            res.add(curStr);
            return;
        }
        int len=curStr.length();
        curStr=curStr+"->"+node.val;
        if(node.left!=null) dfsBTP(curStr, res, node.left);
        if(node.right!=null) dfsBTP(curStr, res, node.right);
        curStr=curStr.substring(0,len);
        return;
    }
}

//bottom up recursion method
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res= new ArrayList<String>();
        if(root==null) return res;
        
        if(root.left==null && root.right==null){
            res.add(Integer.toString(root.val));
            return res;
        }
        
        for(String s: binaryTreePaths(root.left)){
            res.add(Integer.toString(root.val)+"->"+s);
        }
        for(String s: binaryTreePaths(root.right)){
            res.add(Integer.toString(root.val)+"->"+s);
        }
        return res;
    }
}

//BFS
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res= new ArrayList<String>();
        if(root==null) return res;
        LinkedList<TreeNode> nodeq=new LinkedList<TreeNode>();
        LinkedList<String> stringq=new LinkedList<String>();
        nodeq.add(root);
        stringq.add("");
        while(nodeq.size()!=0){
            TreeNode curNode=nodeq.poll();
            String curStr=stringq.poll();
            
            if(curNode.right==null && curNode.left==null){
                curStr+=curNode.val;
                res.add(curStr);
                continue;
            }
            if(curNode.left!=null){
                nodeq.add(curNode.left);
                stringq.add(curStr+curNode.val+"->");
            }
            if(curNode.right!=null){
                nodeq.add(curNode.right);
                stringq.add(curStr+curNode.val+"->");
            }
        }
        return res;
    }
}


//DFS stack
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res= new ArrayList<String>();
        if(root==null) return res;
        Stack<TreeNode> nodestack=new Stack<TreeNode>();
        Stack<String> stringstack=new Stack<String>();
        nodestack.push(root);
        stringstack.push("");
        while(!nodestack.empty()){
            TreeNode curNode=nodestack.pop();
            String curStr=stringstack.pop();
            if(curNode.right==null && curNode.left==null){
                curStr+=curNode.val;
                res.add(curStr);
                continue;
            }
            if(curNode.left!=null){
                nodestack.push(curNode.left);
                stringstack.push(curStr+curNode.val+"->");
            }
            if(curNode.right!=null){
                nodestack.push(curNode.right);
                stringstack.push(curStr+curNode.val+"->");
            }
        }
        return res;
    }
}
