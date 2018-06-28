package Leetcode;

public class ThreeEightZero {

}
//ArrayList + Hashmap + swap
class RandomizedSet {
    HashMap<Integer, Integer> themap;
    ArrayList<Integer> thelist;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.themap=new HashMap<Integer, Integer>();
        this.thelist=new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!themap.containsKey(val)) {
            themap.put(val, thelist.size());
            thelist.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!themap.containsKey(val)) return false;
        int ind=themap.get(val);
        if(ind!=thelist.size()-1){
            int lastnum=thelist.get(thelist.size()-1);
            thelist.set(ind,lastnum);
            themap.put(lastnum,ind);
        }
        thelist.remove(thelist.size()-1);
        themap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r=new Random();
        return thelist.get(r.nextInt(thelist.size()));
    }
}