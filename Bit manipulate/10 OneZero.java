package Leetcode2;

public class OneZero {

}
//1,2D dp, O(M*N) time & space
/*1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty*/

class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)){
            return true;
        }
        if(s == null || p == null){
            return false; 
        }
        
        //dp[][] as the isMatch(s.substring(0, i), s.substring(0,j)). 
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true; 
        
        for(int j=1; j<p.length(); j++){
            if(p.charAt(j)=='*' && dp[0][j-1]) 
                dp[0][j+1]=true;
        }
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1]; 
                    }else{
                        dp[i+1][j+1] = (dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]);
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}