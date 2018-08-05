package Leetcode2;

public class OneThreeNine {

}
//1, backtracking, time exceed
class Solution {
    HashSet<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict=new HashSet<String>(wordDict);
        return bt(dict, s);
    }
    private boolean bt(HashSet<String> dict, String cur){
        if(cur==null || cur.length()==0 || dict.contains(cur))
            return true;
        for(int i=0; i<cur.length()-1; i++){
            if(dict.contains(cur.substring(0, i+1)))
                if(bt(dict, cur.substring(i+1)))
                    return true;
        }
        return false; 
    }
}
//2, dp O(N^2)

public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] f=new boolean[s.length()+1];
    f[0] = true;
    for(int i=1; i<=s.length(); i++){
        for(int j=0; j<i; j++){
            if(f[j]&& wordDict.contains(s.substring(j, i))){
                f[i]=true;
                break;
            }
        }
    }
    return f[s.length()];
}
//3 dp O(N^K) k as dict.size()

public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f=new boolean[s.length()+1];
        f[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(String str: wordDict){
                int j=i-str.length();
                if(j>=0 && f[j] && s.substring(j, i).equals(str)){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }