package Leetcode;

public class OneThreeEight {

}
//hashmap to find random node
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode fakehead=new RandomListNode(-1), oldcurr=head, node=fakehead;
        fakehead.next=head;
        Map<RandomListNode, RandomListNode> themap=new HashMap<RandomListNode, RandomListNode>();
        while(oldcurr!=null){
            RandomListNode newnode=new RandomListNode(oldcurr.label);
            themap.put(oldcurr, newnode);
            node.next=newnode;
            node=newnode;
            oldcurr=oldcurr.next;
        }
        node.next=null;
        oldcurr=head;
        node=fakehead.next;
        while(node!=null){
            if(oldcurr.random!=null) node.random=themap.get(oldcurr.random);
            node=node.next;
            oldcurr=oldcurr.next;
        }
        return fakehead.next;
    }
}

//double every node method
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
       RandomListNode oldcurr=head;
        while(oldcurr!=null){
            RandomListNode copy=new RandomListNode(oldcurr.label);
            copy.next=oldcurr.next;
            oldcurr.next=copy;
            oldcurr=oldcurr.next.next;
        }
        oldcurr=head;
        while(oldcurr!=null){
            if(oldcurr.random != null)  oldcurr.next.random=oldcurr.random.next;
            oldcurr=oldcurr.next.next;
        }
        RandomListNode newhead=head.next, newcurr=newhead;
        oldcurr=head;
        while(oldcurr!=null){
            oldcurr.next=oldcurr.next.next;
            newcurr.next= oldcurr.next==null? null : newcurr.next.next;
            oldcurr=oldcurr.next;
            newcurr=newcurr.next;
        }
        return newhead;
        
    }
}

//recur
public class Solution {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
  public RandomListNode copyRandomList(RandomListNode head) {  
      if(head == null) return null;  
      
      RandomListNode copy = map.get(head);  
      if(copy == null) {  
          copy = new RandomListNode(head.label);  
          map.put(head, copy);  
          copy.next = copyRandomList(head.next);  
          copy.random = copyRandomList(head.random);  
      }  
      return copy;  
  }  
}