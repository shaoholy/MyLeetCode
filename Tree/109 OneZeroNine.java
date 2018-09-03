package Leetcode2;

public class OneZeroNine {

}
//Recursion of preorder
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head; 
        ListNode slow = dummy, fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next; 
        }
        TreeNode curRoot = new TreeNode(slow.next.val);
        curRoot.right = sortedListToBST(slow.next.next);
        slow.next = null;
        curRoot.left = sortedListToBST(head);
        return curRoot; 
        
    }
}