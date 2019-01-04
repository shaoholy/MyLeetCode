/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null; 
        }
        Deque<Node> nodeStack = new ArrayDeque<>(); 
        Node first = null; 
        Node cur = root; 
        Node prev = null; 
        while (cur.left != null) {
            cur = cur.left; 
        }
        first = cur; 
        cur = root; 
        while (!nodeStack.isEmpty() || cur != null) {
            while (cur != null) {
                nodeStack.offerLast(cur);
                cur = cur.left;
            }
            cur = nodeStack.pollLast();
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        
        first.left = prev;
        prev.right = first;
        return first; 
    }
}