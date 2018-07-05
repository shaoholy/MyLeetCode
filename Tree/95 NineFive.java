package Leetcode;

public class NineFive {

}
//Brutal recursion o(Catalan(n)) time o(logN)space https://www.geeksforgeeks.org/program-nth-catalan-number/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return dfs95(1,n);
    }
    private List<TreeNode> dfs95(int start, int end){
        
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(end-start<0) {
            res.add(null);
            return res;
        }
        List<TreeNode> left,right;
        for(int i=start; i<=end;i++){
            left=dfs95(start, i-1);
            right=dfs95(i+1, end);
            for(TreeNode lnode: left){
                for(TreeNode rnode:right){
                    TreeNode newroot=new TreeNode(i);
                    newroot.left=lnode;
                    newroot.right=rnode;
                    res.add(newroot);
                }
            }
        }
        return res;
    }
}

//DP
public static List<TreeNode> generateTrees(int n) {
    List<TreeNode>[] result = new List[n + 1];
    result[0] = new ArrayList<TreeNode>();
    if (n == 0) {
        return result[0];
    }

    result[0].add(null);
    for (int len = 1; len <= n; len++) {
        result[len] = new ArrayList<TreeNode>();
        for (int j = 0; j < len; j++) {
            for (TreeNode nodeL : result[j]) {
                for (TreeNode nodeR : result[len - j - 1]) {
                    TreeNode node = new TreeNode(j + 1);
                    node.left = nodeL;
                    node.right = clone(nodeR, j + 1);
                    result[len].add(node);
                }
            }
        }
    }
    return result[n];
}

private static TreeNode clone(TreeNode n, int offset) {
    if (n == null) {
        return null;
    }
    TreeNode node = new TreeNode(n.val + offset);
    node.left = clone(n.left, offset);
    node.right = clone(n.right, offset);
    return node;
}