package Leetcode;

public class ThreeEightTwo {

}
//random method
class Solution {
    ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head=head; 
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr=head;
        int count=0,result=0;
        Random rdn=new Random();
        while(curr!=null){
            curr=curr.next;
            if(rdn.nextInt(++count)==0) result=count-1;
        }
        curr=head;
        for(int i=0;i<result; i++){
            curr=curr.next;
        }
        return curr.val;
    }
}
