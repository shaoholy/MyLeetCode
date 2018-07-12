package Leetcode;

public class OneFourZero {

}
//normal backtracking not ac time exceed
class Solution {
    int maxlen;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<String>();
        HashSet<Character> chars=new HashSet<>();
        maxlen=0;
        for(String x: wordDict){
            maxlen=Math.max(maxlen, x.length());
            dict.add(x);
            for(char y: x.toCharArray()) chars.add(y);
        }
        List<String> res=new ArrayList<String>();
        for(char z: s.toCharArray()) if(!chars.contains(z)) return res;
        
        if(wordDict.size()==0 || s==null || s.length()==0) return res;
        bt140(s, res, 0, new StringBuilder(), dict);
        return res;
    }
    private void bt140(String s, List<String> res, int startidx, StringBuilder cur,HashSet<String> dict){
        if(startidx==s.length()){
            res.add(new String(cur).trim());
            return; 
        }
        for(int i=startidx; i<s.length()&&i<startidx+maxlen;i++){
            if(dict.contains(s.substring(startidx, i+1))){
                cur.append(s.substring(startidx, i+1)).append(" ");
                bt140(s, res, i+1, cur, dict);
                cur.delete(cur.length()-(i+2-startidx), cur.length());
            }
        }
    }
}
//recursion, using hashmap to store calculated substrings
class Solution {
    HashMap<String, List<String>> themap=new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> dict=new HashSet<>(wordDict);
        List<String> res = new ArrayList<String>();
        if(s==null || s.length()==0 || wordDict.size()==0) 
            return res;
        if(themap.containsKey(s)) 
            return themap.get(s);
        
        
        if(dict.contains(s)) res.add(s);
        for(int j=1; j<s.length(); j++){
            if(dict.contains(s.substring(j))){
                List<String> temp=wordBreak(s.substring(0, j), wordDict);
                for(String x: temp){
                    res.add(x+" "+s.substring(j));
                }
            }
        }
        
        themap.put(s, res);
        return res;
    }
}