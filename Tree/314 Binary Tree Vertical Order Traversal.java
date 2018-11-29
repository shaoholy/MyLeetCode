/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res; 
        }
        
        int min = 0, max = 0; 
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); 
        Queue<TreeNode> nodeQueue = new LinkedList<>(); 
        Queue<Integer> cols = new LinkedList<>(); 
        nodeQueue.add(root); 
        cols.add(0); 
        
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll(); 
            int col = cols.poll(); 
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curNode.val); 
            
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left); 
                cols.offer(col - 1); 
                min = Math.min(min, col - 1); 
            }
            
            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                cols.offer(col + 1); 
                max = Math.max(max, col + 1); 
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res; 
    }
}