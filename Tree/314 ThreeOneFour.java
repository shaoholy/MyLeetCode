package Leetcode;

import java.awt.List;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import org.omg.CORBA.IRObject;

public class ThreeOneFour {

}

//inorder dfs trav, o(n) time, o(h) space
class Solution {
	int leftmax;
	int rightmax;
    public List<List<Integer>> verticalTrav(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        res.add(new LinkedList<Integer>);
        leftmax=0;
        rightmax=0;
        dfs314(root, 0, res);
        return res;
    }
    void dfs314(TreeNode node, int vindex, ArrayList<List<Integer>> res) {
    		if(node==null) return;
    		if(vindex<leftmax) {
    			res.add(0, new LinkedList<Integer>);
    			leftmax=vindex;
    		}
    		if(vindex>rightmax) {
    			res.add(new LinkedList<Integer>);
    			rightmax=vindex;
    		}
    		res.get(vindex-leftmax).add(node.val);
    		dfs314(node.left);
    		dfs314(node.right);
    }
}
//bfs level order traversal, O(n)time O(n)space
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<Position> queue = new LinkedList<>();
        queue.add(new Position(root, 0));
        while (!queue.isEmpty()) {
            Position position = queue.remove();
            min = Math.min(min, position.column);
            max = Math.max(max, position.column);
            List<Integer> list = map.get(position.column);
            if (list == null) {
                list = new ArrayList<>();
                map.put(position.column, list);
            }
            list.add(position.node.val);
            if (position.node.left != null) queue.add(new Position(position.node.left, position.column-1));
            if (position.node.right != null) queue.add(new Position(position.node.right, position.column+1));
        }
        for(int i=min; i<=max; i++) {
            List<Integer> list = map.get(i);
            if (list != null) results.add(list);
        }
        return results;
    }
}
class Position {
    TreeNode node;
    int column;
    Position(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

//same version of 2
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            List<Integer> list = map.get(node.column);
            if (list == null) {
                list = new ArrayList<>();
                map.put(node.column, list);
            }
            list.add(node.node.val);
            if (node.node.left != null) queue.add(new Node(node.node.left, node.column-1));
            if (node.node.right != null) queue.add(new Node(node.node.right, node.column+1));
        }
        List<Integer> columns = new ArrayList<>(map.keySet());
        Collections.sort(columns);
        for(int i=0; i<columns.size(); i++) {
            results.add(map.get(columns.get(i)));
        }
        return results;
    }
}
class Node {
    TreeNode node;
    int column;
    Node(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}