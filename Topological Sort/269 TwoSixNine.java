package Leetcode2;

import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.ws.EndpointReference;

public class TwoSixNine {


//topo sort : 用两个hash表, 一个来存每个出现过的字符的入度, 另一个来存一个字符指向的字符集合, 
//即一个字符应该在另外字符的前面. 然后就每次找出一个入度为0的字符, 并且更新这个字符指向的字符集入度减1
	public String alienOrder(String[] words) {
		StringBuilder res=new StringBuilder();
		HashMap<Character, Integer> indegree=new HashMap<Character, Integer>();
		HashMap<Character, HashSet<Character>> pointto=new HashMap<Character,HashSet<Character>>();
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<words[i].length(); j++) {
				char x=words[i].charAt(j);
					indegree.put(x, 0);

			}
		}
		
		for(int i=1; i<words.length; i++) {
			String prev=words[i-1];
			String curs=words[i];
			for(int j=0; j<Math.min(prev.length(), curs.length()); j++) {
				if(prev.charAt(j)==curs.charAt(j)) continue;
				else {
					if(!pointto.containsKey(prev.charAt(j))) {
						HashSet<Character> set=new HashSet<Character>();
						set.add(curs.charAt(j));
						pointto.put(prev.charAt(j), set);
						indegree.put(curs.charAt(j), indegree.get(curs.charAt(j))+1);
					}else {
						if(!pointto.get(prev.charAt(j)).contains(curs.charAt(j))) {
							pointto.get(prev.charAt(j)).add(curs.charAt(j));
							indegree.put(curs.charAt(j), indegree.get(curs.charAt(j))+1);
						}
					}
				}
			}
		}
		
		int charnum=indegree.size();
		LinkedList<Character> que=new LinkedList<Character>();
		for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0) {
				que.offer(entry.getKey());
				indegree.remove(entry.getKey());
			}
		}
		
		while(!que.isEmpty()){
			int len = que.size();
			for (int i = 0; i < len; i++) {
				char cur = que.poll();
				res.append(cur);
				for (char y : pointto.get(cur)) {
					indegree.put(y, indegree.get(y) - 1);
					if(indegree.get(y)==0) que.offer(y);
				}
			}

		}
		
		
		return res.length()==charnum? new String(res):"";
	}
}