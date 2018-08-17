package Leetcode2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ThreeFourSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class MovingAverage {
	    private double previousSum;
	    private int maxSize;
	    private Deque<Integer> currentWindow;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	    		this.maxSize = size;
	        currentWindow = new ArrayDeque<Integer>();
	        previousSum = 0.0;
	    }
	    
	    public double next(int val) {
	    		if(currentWindow.size() == maxSize) {
	    			int poller = currentWindow.poll();
	    			previousSum -= poller;
	    		}
	    	
        		currentWindow.addLast(val);
        		previousSum += val;
        		return previousSum/(double)currentWindow.size();
	    }
	}

}
