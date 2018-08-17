package Leetcode2;

public class FiveOneSIx {

}
//1, 2D dp, N^2 time & space
public int longestPalindromeSubseq(String s) {
    if(s == null || s.length() ==0){
        return 0; 
    }
    if(s.length() == 1){
        return 1; 
    }
    int[][] dp = new int[s.length()][s.length()]; 
    /*dp[i][j] 代表从i到j字符内longestPSub的长度。 规律如下：
    1， i<=j; 
    2, i==j 时， dp[i][j] = 1; 
    3, j - i == 1， dp[i][j] = s.charAt(j) == s.charAt(i)? 2:1; 
    4, j - i > 1, dp[i][j] = s.charAt(j) == s.charAt(i)? 2 + dp[i+1][j-1] : 
    Math.max(dp[i][j-1], dp[i+1][j]); */
    for(int i= s.length() - 1; i >= 0; i-- ){
        for(int j = i; j < s.length(); j++){
            if(i == j){
                dp[i][j] = 1;
            }else if (j - i == 1){
                dp[i][j] = s.charAt(j) == s.charAt(i)? 2:1;
            }else{
                dp[i][j] = s.charAt(j) == s.charAt(i)? 2 + dp[i+1][j-1] :
                Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
    }
    return dp[0][n-1]; 
}