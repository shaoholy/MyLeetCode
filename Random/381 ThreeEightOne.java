package Leetcode;

public class ThreeEightOne {

}
class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> themap;
    ArrayList<Integer> thelist;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.themap=new HashMap<Integer, HashSet<Integer>>();
        this.thelist=new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!themap.containsKey(val)){
            thelist.add(val);
            themap.put(val, new HashSet<Integer>());
            themap.get(val).add(thelist.size()-1);
            return true;
        }else{
            thelist.add(val);
            themap.get(val).add(thelist.size()-1);
            return false;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!themap.containsKey(val)) return false;
        if(thelist.get(thelist.size()-1)==val){
            thelist.remove(thelist.size()-1);
            if(themap.get(val).size()==1) themap.remove(val);
            else themap.get(val).remove(thelist.size());
        }else{
            int replaceval=thelist.get(thelist.size()-1),posi=-1;
            for(Integer x: themap.get(val)){
                posi=x;
                break;
            }
            themap.get(replaceval).remove(thelist.size()-1);
            themap.get(replaceval).add(posi);
            if(themap.get(val).size()==1) themap.remove(val);
            else themap.get(val).remove(posi);
            thelist.set(posi, replaceval);
            thelist.remove(thelist.size()-1);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r=new Random();
        return thelist.get(r.nextInt(thelist.size()));
    }
}