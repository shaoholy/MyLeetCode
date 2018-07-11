package Leetcode;

import java.util.HashMap;
import java.util.Objects;

public class TwoNineOne {

	public static void main(String[] args) {
		TwoNineOne TNO=new TwoNineOne();
		String pattern="abab", str = "redblueredblue";
		System.out.println(TNO.wordPatternMatch(pattern, str));

	}
	public boolean wordPatternMatch(String pattern, String str) {
        String[] strs=new String[pattern.length()];
        return bt291(str, 0, strs, 0, pattern.toCharArray());
        
    }
	private boolean bt291(String str,int startidx, String[] strs, int stridx, char[] pattern) {
		if(stridx==strs.length && startidx==str.length()) {

			if(arraypattern(pattern, strs)) return true;
			else return false;
		}else if(stridx<strs.length && startidx==str.length() ||stridx==strs.length && startidx<str.length()) return false;
		if(str.length()-startidx<strs.length-stridx) return false;
		
		for(int i=startidx; i<str.length(); i++) {
			strs[stridx]=str.substring(startidx, i+1);
			if(bt291(str, i+1, strs, stridx+1, pattern)) return true;
			else continue;
		}
		return false;
		
	}
	private boolean arraypattern(char[] pattern, String[] strs) {
		if(pattern.length!=strs.length) return false;
		HashMap<Object, Integer> map=new HashMap<>();
		for(int i=0; i<pattern.length; i++) {
			if (!Objects.equals(map.putIfAbsent(pattern[i], i), map.putIfAbsent(strs[i], i))) {
				return false;
			}
		}
		return true;
	}

}
