package Leetcode2;

public class TwoSevenTwo {
}

///


  public List<Integer> closestKValues(TreeNode root, double target, int k) {

    if (k == 0) {
      return new ArrayList<Integer>();
    }
    List<Integer> buff = new ArrayList<Integer>();
    inTrav(root, buff);
    return binarySearch(buff, target, k);
  }

  private void inTrav(TreeNode node, List<Integer> buff) {
    if (node == null) {
      return;
    }
    inTrav(node.left, buff);
    buff.add(node.val);
    inTrav(node.right, buff);
  }

  private List<Integer> binarySearch(List<Integer> buff, double target, int k) {
    List<Integer> res = new ArrayList<Integer>();
    if (buff.size() == k) {
      res.addAll(buff);
      return res;
    }
    int left = 0, right = buff.size() - k;
    while (left < right) {
      int mid = left + (right - left) / 2;
      double leftGap = target - buff.get(mid);
      double rightGap = buff.get(mid + k) - target;
      if (rightGap < leftGap) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    for (int i = left; i < left + k; i++) {
      res.add(buff.get(i));
    }
    return res;
  }