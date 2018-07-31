package Leetcode2;

import java.util.List;

public class TwoSevenOne {

}
//Time Complexity - O(n)， Space Complexity - O(n)
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    		if(strs.size()==0 || strs==null) return "";
        StringBuilder sb=new StringBuilder();
        for(String s:strs) {
        		int len=s.length();
        		sb.append(len);
        		sb.append('/');
        		sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()==0) return res;
        int idx=0;
        while(idx<s.length() && s.indexOf('/')>0) {
        		int nextidx=s.indexOf('/', idx);
        		int thislen=Integer.parseInt(s.substring(idx, nextidx));
        		res.add(s.substring(nextidx+1, nextidx+1+thislen));
        		idx=nextidx+1+thislen;
        }
        return res;
    }
}