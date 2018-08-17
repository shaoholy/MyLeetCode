package Leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreeFiveNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	class Logger {
	    Map<String, ArrayList<Integer>> log;
	    Map<Integer, HashSet<String>> inTen; 
	    int lasttime; 
	 
	    /** Initialize your data structure here. */
	    public Logger() {
	    		log = new HashMap<String, ArrayList<Integer>>();
	    		inTen = new HashMap<Integer, HashSet<String>>();
	    		lasttime = 0;
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	    		boolean res = true; 
	        for(int i = lasttime - 10; i <= timestamp -10; i++) {
	        		inTen.remove(i);
	        }
	        
	        for(Integer x: inTen.keySet()) {
	        		if(inTen.get(x).contains(message)) {
	        			res = false;
	        		}
	        }
	        lasttime = timestamp;
	        
	        if(inTen.containsKey(timestamp)) {
	        		inTen.get(timestamp).add(message);
	        }else {
	        		HashSet<String> newset = new HashSet<String>();
	        		newset.add(message);
	        		inTen.put(timestamp, newset);
	        }
	    	
	    		if(log.containsKey(message)) {
	        		log.get(message).add(timestamp);
	        }else {
	        		ArrayList<Integer> newlist = new ArrayList<Integer>();
	        		newlist.add(timestamp);
	        		log.put(message, newlist);
	        }
	    		return res;
	    	
	    }
	
	}
}
