package Leetcode;

public class OneZeroTwo {

}
//two ArrayDeque swap until empty
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        ArrayDeque<TreeNode> firstlevel = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> secondlevel = new ArrayDeque<TreeNode>();
        //TreeNode cur=root;
        firstlevel.push(root);
        while(!firstlevel.isEmpty() ){
            List<Integer> thislevel=new ArrayList<Integer>();
            while(!firstlevel.isEmpty()){
                TreeNode cur=firstlevel.pop();
                thislevel.add(cur.val);
                if(cur.left!=null) secondlevel.add(cur.left);
                if(cur.right!=null) secondlevel.add(cur.right);
            }
            res.add(thislevel);
            ArrayDeque<TreeNode> temp=firstlevel;
            firstlevel=secondlevel;
            secondlevel=temp;
        }
        return res;
    }
}

//DFS

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    levelHelper(res, root, 0);
    return res;
}

public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
    if (root == null) return;
    if (height >= res.size()) {
        res.add(new LinkedList<Integer>());
    }
    res.get(height).add(root.val);
    levelHelper(res, root.left, height+1);
    levelHelper(res, root.right, height+1);
}