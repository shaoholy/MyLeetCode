package Leetcode2;

public class OneFourSix {

}
//1, timestamp + priorityqueue
class LRUCache {
    static int timestamp = 0; 
    int fullsize; 
    PriorityQueue<entry> q; 
    HashMap<Integer, entry> map; 
    public LRUCache(int capacity) {
        this.fullsize = capacity; 
        q = new PriorityQueue<entry>((a, b) -> (a.time - b.time));
        map = new HashMap<Integer, entry>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1; 
        }else{
            entry curEntry = map.get(key);
            entry newEntry = new entry(key, ++timestamp, curEntry.value);
            q.remove(curEntry);
            q.add(newEntry);
            map.put(key, newEntry);
            return newEntry.value;
        }
    }
    
    public void put(int key, int value) {
        entry newEntry = new entry(key, ++timestamp, value);
        if(map.containsKey(key)){
            q.remove(map.get(key));
        }else if(map.size() == fullsize){
            entry oldEntry = q.poll();
            map.remove(oldEntry.key);
        }
        q.add(newEntry);
        map.put(key, newEntry);
    }
}

class entry{
    int key; 
    int value; 
    int time; 
    public entry(int k, int t, int v){
        this.key = k;
        this.value = v; 
        this.time = t; 
    }
}

//2, inner class DlinkNode
class LRUCache {
    HashMap<Integer, DlinkNode> dict; 
    DlinkNode head = null; 
    DlinkNode tail = null;
    int fullsize; 
    public LRUCache(int capacity) {
        this.fullsize = capacity; 
        dict = new HashMap<Integer, DlinkNode>();
    }
    
    public int get(int key) {
        if(!dict.containsKey(key)){
            return -1;
        }else{
            this.moveToHead(dict.get(key));
            return dict.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)){
            this.moveToHead(dict.get(key));
            dict.get(key).val = value;
        }else{
            DlinkNode newnode = new DlinkNode(key, value);
            if(dict.size() == fullsize){
                dict.remove(tail.key);
                this.deleteFromList(tail);
            }
            dict.put(key, newnode);
            this.addToFront(newnode);
        }
    }
    
    public void moveToHead(DlinkNode cur){
        deleteFromList(cur);
        this.addToFront(cur);
        this.head = cur; 
    }
    
    public void deleteFromList(DlinkNode cur){
        if(cur == tail){
            tail = tail.pre;
        }
        if(cur == head){
            head = head.next;
        }
        DlinkNode p = cur.pre;
        DlinkNode n = cur.next;
        if(p != null) p.next = n; 
        if(n != null) n.pre = p; 
    }
    public void addToFront(DlinkNode cur){
        if(head == null){
            head = cur; 
            tail = cur;
        }else{
            this.head.pre = cur; 
            cur.next = head; 
            cur.pre = null;
            head = cur; 
        }
    }
    
    
    class DlinkNode{
        int key; 
        int val; 
        DlinkNode pre; 
        DlinkNode next; 
        public DlinkNode(int k, int v){
            this.key = k; 
            this.val = v;
            pre = null;
            next = null; 
        }
    }
}