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
    Deque<TreeNode> predStack = new ArrayDeque<>();
    Deque<TreeNode> succStack = new ArrayDeque<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
       
        List<Integer> res  = new ArrayList<>();
        initPred(root,target); //stack up all smaller nodes on one route
        initSucc(root,target); // stack up all larger nodes on one route
        if(!predStack.isEmpty() && !succStack.isEmpty() && predStack.peek().val==succStack.peek().val)
            getNextPred();//if there is node.val == target, pop() it so there is no duplicate
        while(k-->0) {
            if(predStack.isEmpty()) {
                res.add(getNextSucc());
            } else if(succStack.isEmpty()) {
                res.add(getNextPred());
            } else {
                double sDiff = Math.abs((double)(succStack.peek().val)-target);
                double pDiff = Math.abs((double)(predStack.peek().val)-target);
                if(sDiff<pDiff)
                    res.add(getNextSucc());
                else
                    res.add(getNextPred());
            }
        }
        return res;
    }
    private void initPred(TreeNode root, double target) {
        while(root!=null) {
            if(root.val==target) {
                 predStack.push(root);
                break;
            }
            else if(root.val<target) {
                predStack.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
   private void initSucc(TreeNode root,double target) {
        while(root!=null) {
            if(root.val==target) {
                 succStack.push(root);
                break;
            } else if(root.val>target) {
                succStack.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    private int getNextPred() {//1, give the value of next pre and pop it; 2, push all right nodes of its left
        TreeNode cur = predStack.pop();
        int val = cur.val;
        cur  = cur.left;
        while(cur!=null) {
            predStack.push(cur);
            cur = cur.right;
        }
        return val;
    }
    
    
    private int getNextSucc() { // contrary to getNextPred()
        TreeNode cur = succStack.pop();
        int val = cur.val;
        cur  = cur.right;
        while(cur!=null) {
            succStack.push(cur);
            cur = cur.left;
        }
        return val;
    }
}