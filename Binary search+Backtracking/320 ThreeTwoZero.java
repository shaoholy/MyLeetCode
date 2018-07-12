package Leetcode;

import java.util.ArrayList;

public class ThreeTwoZero {
	public static void main(String[] args) {
		ThreeTwoZero TTO=new ThreeTwoZero();
		String str = "word";
		System.out.println(TTO.generateAbbreviations(str) );

	}
	
	//1, normal backtracking
	public ArrayList<String> generateAbbreviations(String word) {
        ArrayList<String> results = new ArrayList<>();
        bt320(results, word, 0, new StringBuilder());
        return results;
    }
	private void bt320(ArrayList<String> results, String word, int startpoint, StringBuilder cur) {
		if(startpoint==word.length()) {
			results.add(new String(cur));
			return;
		}
		cur.append(word.charAt(startpoint));
		bt320(results, word, startpoint+1, cur);
		cur.deleteCharAt(cur.length()-1);
		if(startpoint==0 || !(cur.charAt(cur.length()-1)-'1'>=0 && '9'-cur.charAt(cur.length()-1)>=0 )) {
			for(int i=1; i<=word.length()-startpoint; i++) {
				cur.append(i);
				bt320(results, word, startpoint+i, cur);
				cur.deleteCharAt(cur.length()-1);
			}
		}
	}
	
	//also backtracking , 关键见注释
    private void dfs(char[] wa, int from, int last, String abbr, ArrayList<String> result) {
    	    System.out.println(abbr);
        if (from == wa.length) {
            result.add(abbr);
            return;
        }
        for(int i=0; i<=wa.length-from; i++) {
            dfs(wa, from + Math.max(1, i), i, (i==0? abbr+wa[from] : abbr + i), result);
            if (last > 0) break;//关键行！ 当上一个last不为数字时才继续循环！
        }
    }
    public ArrayList<String> generateAbbreviations(String word) {
        ArrayList<String> result = new ArrayList<>();
        dfs(word.toCharArray(), 0, 0, "", result);
        return result;
    }

}
