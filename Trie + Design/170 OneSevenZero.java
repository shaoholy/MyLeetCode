package Leetcode2;

import java.util.HashMap;

public class OneSevenZero {

}
//1, o(1) to add, o(n) to find
class TwoSum 
{
    HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
       for(int x: map.keySet()) {
    	   	 int left = value - x; 
    	   	 if(left == x) {
    	   		 if(map.get(x) >= 2) return true;
    	   	 }else {
    	   		 if(map.containsKey(left)) return true;
    	   	 }
       }
       return false;
    }
}
//1, O(n) to add, O(1) to find
class TwoSum{
    HashMap<Integer, Integer> map;
    HashSet<Integer> sums; 
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        sums = new HashSet<Integer>(); 
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
		for(int x: map.keySet()) {
			sums.add(x + number);
		}
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
       return sums.contains(value);
    }
}

//3, treemap O(logN) time to add, o(N) time to find
TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>(); 
public void add(int number) {
    tree.put(number, tree.getOrDefault(number, 0) + 1);
}


public boolean find(int value) {
    int lo = tree.firstKey(), hi = tree.lastKey(); 
    while(lo != hi){
        if(lo + hi == value){
            return true;
        }else if(lo + hi > value){
            hi = tree.lowerKey(hi);
        }else{
            lo = tree.higherKey(lo);
        }
    }
    return lo * 2 == value && tree.get(lo) > 1;
}
