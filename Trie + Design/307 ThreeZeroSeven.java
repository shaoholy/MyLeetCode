package Leetcode2;

public class ThreeZeroSeven {

}
/*1, Binary Indexed Tree, update & getSum op takes logN time. 
 * 
zhongdian1:  * BIT[i] = ([i] is a left child) ? the partial sum from its left most
descendant to itself : the partial sum from its parent (exclusive) to
itself. (check the range of "__"). Such as: BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...

zhongdian2:  i - or + = (i & -i), up/down to closest 2^n */


class NumArray {
    int[] BIT;
    int[] n; 
    public NumArray(int[] nums) {
        n = nums; 
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            int start = i + 1; 
            while(start < BIT.length){
                BIT[start] += nums[i];
                start += (start & -start);
            }
        }
    }
    
    public void update(int i, int val) {
        int gap = val - n[i];
        n[i] = val;
        i++;
        while(i < BIT.length){
            BIT[i] += gap; 
            i += (i&-i);
        }
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);        
    }
    private int getSum(int i){
        int res = 0; 
        i++;
        while(i > 0){
            res += BIT[i];
            i -= (i&-i);
        }
        return res; 
    }
}

//2.Binary Node solution, easy to understand, O(logN) for both update & getSum 

class NumArray {
    class Node {
        int start;
        int end;
        int sum;
        Node left;
        Node right;
        Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public NumArray(int[] nums) {
        root = build(0, nums.length - 1, nums);
    }
    
    private Node build(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        Node left = build(start, mid, nums);
        
        Node right = build(mid + 1, end, nums);
        
        Node root = new Node(start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public void update(int i, int val) {
        updateTree(root, i, val);
    }
    
    private void updateTree(Node root, int i, int val) {
        
        if (root.start == root.end && root.start == i) {
            root.sum = val;
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (i <= mid) {
            updateTree(root.left, i, val);
        } else {
            updateTree(root.right, i, val);
        }
        
        root.sum = root.left.sum + root.right.sum;
        
    }
    
    public int sumRange(int i, int j) {
        return queryTree(root, i, j);
    }
    private int queryTree(Node root, int start, int end) {
        if (end < root.start || start > root.end) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        
        int right = 0;
        int left = 0;
        if (start <= mid) {
            left = queryTree(root.left, start, Math.min(mid, end));
        } 
        if (end >= mid + 1) {
            right = queryTree(root.right, Math.max(mid + 1, start), end);
        }
        return left + right;
    }
}