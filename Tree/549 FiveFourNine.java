package Leetcode2;

public class FiveFourNine {
}
// recur, with returnType, O(N) time, O(H) space

public class Solution {
  int max;

  public int longestConsecutive2(TreeNode root) {
    max = 0;
    dfs(root);
    return max;
  }

  private returnType dfs(TreeNode node) {
    returnType rt = new returnType(0, 0);
    if (node == null) {
      return rt;
    }

    returnType leftRes = dfs(node.left);
    returnType rightRes = dfs(node.right);

    int leftUp = (leftRes.maxUp == 0 || node.left.val - 1 != node.val) ? 1 : 1 + leftRes.maxUp;
    int rightUp = (rightRes.maxUp == 0 || node.right.val - 1 != node.val) ? 1 : 1 + rightRes.maxUp;
    int leftDown = (leftRes.maxUp == 0 || node.left.val + 1 != node.val) ? 1 : 1 + leftRes.maxDown;
    int rightDown = (rightRes.maxUp == 0 || node.right.val + 1 != node.val) ? 1 : 1 + rightRes.maxDown;

    rt.maxDown = Math.max(leftDown, rightDown);
    rt.maxUp = Math.max(leftUp, rightUp);
    max = Math.max(max, Math.max(rt.maxUp, rt.maxDown));

    int turnlen = 0;
    if (node.left != null && node.right != null && node.left.val - 1 == node.val && node.val == node.right.val + 1) {
      turnlen = leftUp + rightDown - 1;
    } else if (node.left != null && node.right != null && node.left.val + 1 == node.val && node.val == node.right.val - 1) {
      turnlen = leftDown + rightUp - 1;
    }
    max = Math.max(max, turnlen);
    return rt;
  }
}

class returnType {
  int maxUp, maxDown;

  public returnType(int up, int down) {
    this.maxDown = down;
    this.maxUp = up;
  }
}