package Leetcode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoEightEight {

}
//
public class ValidWordAbbr {
    Map<String, Set<String> > map = new HashMap<>();
 
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
        		String dictEntry = getAbbr(s);
        		if(!map.containsKey(dictEntry)) {
        			Set<String> newset = new HashSet<String>();
        			map.put(dictEntry, newset);
        		}
        		map.get(dictEntry).add(s);
        }
    }
 
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) && (map.get(abbr).contains(word) && map.get(abbr).size() <= 1);
    }
    private String getAbbr(String s) {
    		String dictEntry = new String();
		if(s.length() <= 2) {
			dictEntry = s;
		}else {
			dictEntry += s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
		}
		return dictEntry;
    }
}
