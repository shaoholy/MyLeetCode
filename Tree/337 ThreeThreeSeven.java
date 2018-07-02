package Leetcode;

public class ThreeThreeSeven {

}
//recursion with int input and boolean flag
class Solution {
    public int rob(TreeNode root) {
        return getmax(root, 0, true);
    }
    private int getmax(TreeNode node, int cursum, boolean flag){
        if(node==null) return cursum; 
        if(flag){
            int posi1=getmax(node.left, cursum+node.val, false)+getmax(node.right, cursum+node.val, false)-cursum-node.val;
            int posi2=getmax(node.left, cursum, true)+getmax(node.right,cursum, true)-cursum;
            return Math.max(posi1, posi2);
        }else{
            return getmax(node.left, cursum, true)+getmax(node.right, cursum, true)-cursum;
        }
        
    }
}
//recursion: greedy, use in[2] to store two possibilities each node
public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);
    int[] res = new int[2];

    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = root.val + left[0] + right[0];
    
    return res;
}