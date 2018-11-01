class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<TreeNode, TreeNode>();
        TreeNode match = dfsFindMatch(root, childToParent, k); 
        Queue<TreeNode> que = new ArrayDeque<>(); 
        que.add(match); 
        Set<TreeNode> vis = new HashSet<>(); 
        while(!que.isEmpty()) {
            TreeNode curnode = que.poll(); 
            vis.add(curnode);
            if (isLeaf(curnode)) {
                return curnode.val; 
            }
            if (curnode.left != null) {
                if (!vis.contains(curnode.left)){
                    que.add(curnode.left); 
                }
            }
            if (curnode.right != null) {
                if (!vis.contains(curnode.right)){
                    que.add(curnode.right); 
                }
            }
            if (childToParent.containsKey(curnode) && !vis.contains(childToParent.get(curnode))) {
                que.add(childToParent.get(curnode));
                childToParent.remove(curnode);
            }
        }
        return -1; 
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    private TreeNode dfsFindMatch(TreeNode node, Map<TreeNode, TreeNode> childToParent, int k) {
        if (node == null) {
            return null; 
        }
        if (node.val == k) {
            return node; 
        }
        if (node.left != null) {
            childToParent.put(node.left, node); 
            TreeNode leftres = dfsFindMatch(node.left, childToParent, k); 
            if (leftres != null) {
                return leftres; 
            }
        }
        if (node.right != null) {
            childToParent.put(node.right, node); 
            TreeNode rightres = dfsFindMatch(node.right, childToParent, k); 
            if (rightres != null) {
                return rightres; 
            }
        }
        return null; 
    }
}