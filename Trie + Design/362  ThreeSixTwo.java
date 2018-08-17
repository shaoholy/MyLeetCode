package Leetcode2;

import javax.jws.WebParam.Mode;

public class ThreeSixTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1, Design Hit Counter
	public class HitCounter {
	    private int[] hits;
	    //private boolean[] hasHits;
	    int lasttime; 
	    int mod; 
	    /** Initialize your data structure here. */
	    public HitCounter() {
	        hits = new int[300];
	        //hasHits = new boolean[300];
	        mod = 0;
	        lasttime = 0;
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        int newmod = (timestamp - 1) / 300;
	        if (lasttime == timestamp) {
	        		hits[(lasttime - 1) % 300]++;
	        }else {
	        		if(mod == newmod) {
	        			for(int i = (lasttime - 1) % 300 + 1; i < (timestamp - 1) % 300; i++) {
	        				hits[i] = 0;
	        			}
	        			hits[(timestamp - 1) % 300] = 1; 
	        		}else if (newmod - mod == 1 && (timestamp - 1) % 300 < (lasttime - 1) % 300) {
	        			for(int i = (lasttime - 1) % 300 + 1; i < 300; i++) {
	        				hits[i] = 0;
	        			}
	        			for(int i = 0; i < (timestamp - 1) % 300; i++) {
	        				hits[i] = 0;
	        			}
	        			hits[(timestamp - 1) % 300] = 1;
	        		}else {
	        			for(int i = 0; i < 300; i++) {
	        				if(i == (timestamp - 1) % 300) {
	        					hits[i] = 1; 
	        				}else {
	        					hits[i] = 0;
	        				}
	        			}
	        		}
	        }
	        mod = newmod; 
	        lasttime = timestamp;
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        int sum = 0;
	    		int newmod = (timestamp - 1) / 300;
	    		if(newmod == mod) {
	    			for(int i = 0; i < 300; i++) {
	    				if(i > (lasttime - 1) % 300 && i <= (timestamp - 1) % 300) {
	    					continue;
	    				}
	    				sum += hits[i];
	    			}
	    			return sum; 
	    		}else if (newmod - mod ==1) {
	    			for(int i = 0; i < 300; i++) {
	    				if(i > (lasttime - 1) % 300 && i <= (timestamp - 1) % 300) {
	    					continue;
	    				}
	    				sum += hits[i];
	    			}
	    			return sum; 
	    		}else {
	    			return 0; 
	    		}
	    }
	}
	//2, use one int[] hits to record hit count within one sec, another to record  timestamp of given hits[i]
	public class HitCounter {
	    private int[] hits;
	    private int[] times; 
	    publice HitCounter() {
	    		hits = new int[300];
	    		times = new int[300];
	    }
	    public void hit(int timestamp) {
	    		if(times[timestamp % 300] == timestamp) {
	    			hits[timestamp % 300]++;
	    		}else {
	    			hits[timestamp % 300] = 1;
	    			times[timestamp % 300] = timestamp;
	    		}
	    }
	    public int getHits(int timestamp) {
	    		int sum = 0;
	    		for(int i = 0; i < 300; i++) {
	    			if(timestamp - times[i] >= 300 ) {
	    				continue;
	    			}
	    			sum += hits[i];
	    		}
	    		return sum; 
	    }
	
	}
}
