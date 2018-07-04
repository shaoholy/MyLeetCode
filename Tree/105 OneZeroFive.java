package Leetcode;

public class OneZeroFive {

}

//hash the inorder, stack to judge right position, o(n) time o(n) space
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        TreeNode cur;
        Stack<nodepair> nodestack=new Stack<nodepair>();
        HashMap<Integer, Integer> inordermap=new HashMap<Integer,Integer>();
        for(int j=0; j<inorder.length; j++) inordermap.put(inorder[j],j);
        nodestack.push(new nodepair(root, inordermap.get(root.val)));
        for(int i=1; i<preorder.length; i++){
            cur=nodestack.peek().node;
            int ji=inordermap.get(preorder[i]), jcur=inordermap.get(cur.val);
            if(jcur>ji){
                cur.left=new TreeNode(preorder[i]);
                nodestack.push(new nodepair(cur.left, ji));
            }else{
                cur.left=null;
                while(!nodestack.empty() && nodestack.peek().posi<ji) cur=nodestack.pop().node;
                cur.right=new TreeNode(preorder[i]);
                nodestack.push(new nodepair(cur.right,ji));
            }
        }
        
        return root;
    }
}
class nodepair{
    int posi;
    TreeNode node;
    public nodepair(TreeNode node, int posi){
        this.posi=posi;
        this.node=node;
    }
}

// improved, using inorder character directly, o(n) time, o(h) space;
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;
    Stack<TreeNode> s = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]), cur = root;
    for (int i = 1, j = 0; i < preorder.length; i++) {
        if (cur.val != inorder[j]) {
            cur.left = new TreeNode(preorder[i]);
            s.push(cur);
            cur = cur.left;
        } else {
            j++;
            while (!s.empty() && s.peek().val == inorder[j]) {
                cur = s.pop();
                j++;
            }
            cur = cur.right = new TreeNode(preorder[i]);
        }
    }
    return root;
}

// recursion divide and conquer, o(n) time, o(n) space
class Solution {
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        return dfs105two(preorder, inorder, 0, inorder.length);
    }

    private TreeNode dfs105two(int[] input, int[] inorder, int start, int end){
        if(index==input.length || start-end==0) return null;
        int j=start;
        for(; j<end; j++){
                if(inorder[j]==input[index]) break;}
        TreeNode newnode=new TreeNode(input[index]);
        index++;
        newnode.left=dfs105two(input, inorder, start, j);
        newnode.right=dfs105two(input, inorder, j+1, end);
        return newnode;
    }
}