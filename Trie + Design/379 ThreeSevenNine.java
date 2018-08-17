package Leetcode2;

import java.util.HashSet;

import javax.transaction.TransactionRolledbackException;

public class ThreeSevenNine {

}
//1
public class _379 {
	HashSet<Integer> emp; 
	HashSet<Integer> taken; 
    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public _379(int maxNumbers) {
    		emp = new HashSet<Integer>();
    		for(int i = 0; i < maxNumbers; i++) {
    			emp.add(i);
    		}
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
    		if(emp.size() != 0) {
    			int res = emp.iterator().next();
    			emp.remove(res);
    			return res;
    		}else {
    			return -1; 
    		}
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
    		return emp.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
    		emp.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */