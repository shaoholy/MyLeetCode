package Leetcode2;

public class FourFour {

}
//1, 2D dp, o(M*N*N) time, O(M*N) space
/* three conditions: 
1, p.charAt(j) is Letter && p.charAt(j) ++ s.charAt(i) : dp[i+1][j+1] = dp[i][j];
2, p.charAt(j) == '?' : dp[i+1][j+1] = dp[i][j]; 
3, p.charAt(j) == '*' : dp[i+1][j+1] = (dp[i+1][j] to dp[0][j] any of true)
*3, improved to : dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1]
dp[i+1][j]代表*为空的时候； dp[i][j+1]代表*不为空的时候。 */

public boolean isMatch(String s, String p) {
    if(s == null || p == null){
        return false; 
    }
    boolean[][] dp=new boolean[s.length()+1][p.length()+1];
    
    //dp[i][j] as isMatch with s.substring(0, i) and p.substring(0, j)
    dp[0][0] = true; 
    
    for(int j = 0; j < p.length(); j++){
        if(p.charAt(j) == '*' && dp[0][j]){
            dp[0][j+1] = true;
        }
    }
    
    for(int i = 0; i < s.length(); i++){
        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                dp[i+1][j+1] = dp[i][j];
            }else if(p.charAt(j) == '*'){
            		dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
            }
        }
    }
    return dp[s.length()][p.length()];
}

//2, two pointer solution. O(MN) time max, general O(M+N), O(1) space; 

class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false; 
        }
        // startidx: *点； match： 对应当前*点的位置； 
        // 原理： 尽量少的用*去match当前位置的字符串。 如果后面不符合或者p到头了，再回到*match点把match++后再尝试。
        int startIdx = -1, idxs = 0, idxp = 0, match = 0; 
        while(idxs<s.length()){
            if(idxp < p.length()  && (p.charAt(idxp) == '?' || s.charAt(idxs) == p.charAt(idxp))){
                idxs++;
                idxp++;
            }else if(idxp < p.length()  && p.charAt(idxp) == '*'){
                startIdx=idxp; 
                idxp++; 
                match = idxs; 
            }else if(startIdx != -1){
                match++; 
                idxp = startIdx+1; 
                idxs = match; 
            }else{
                return false; 
            }
        }
        
        
        while(idxp<p.length() && p.charAt(idxp) == '*'){
            idxp++;
        }
        return idxp == p.length();
    }
}