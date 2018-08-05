package Leetcode2;

public class SixTwo {

}
//1, dp O(M*N) time & space
public int uniquePaths(int m, int n) {
    int[][] dp=new int[m][n];
    int cursum=m+n-3;
    dp[m-1][n-1]=1;
    while(cursum>=0){
        for(int curm=0; curm<m; curm++){
            int curn=cursum-curm;
            if(curn<0 || curn>=n)
                continue;
            int right= curn+1>=n? 0:dp[curm][curn+1];
            int below= curm+1>=m? 0:dp[curm+1][curn];
            dp[curm][curn]=below+right;
        }
        cursum--;
    }
    return dp[0][0];
}
//2, math O((M-N)*N)) time, O(1) space

public int uniquePaths(int m, int n) {
     if(m == 1 || n == 1)
         return 1;
     m--;
     n--;
     if(m < n) {              // Swap, so that m is the bigger number
         m = m + n;
         n = m - n;
         m = m - n;
     }
     long res = 1;
     int j = 1;
     for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
         res *= i;
         res /= j;
     }
         
     return (int)res;
 }