package Leetcode2;

public class SixThree {

}
//1 2-D dp
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m=obstacleGrid.length, n=obstacleGrid[0].length;
    int[][] dp=new int[m][n];
    int cursum=m+n-3;
    dp[m-1][n-1]= obstacleGrid[m-1][n-1]==1? 0:1;
    while(cursum>=0){
        for(int curm=0; curm<m; curm++){
            int curn=cursum-curm;
            if(curn<0 || curn>=n)
                continue;
            if(obstacleGrid[curm][curn]==1){
                dp[curm][curn]=0;
            }else{
                int right= curn+1>=n? 0:dp[curm][curn+1];
                int below= curm+1>=m? 0:dp[curm+1][curn];
                dp[curm][curn]=below+right;
            }
        }
        cursum--;
    }
    return dp[0][0];
}
//2 1-D dp
private static final int OBSTACLE = 1;

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0) {
        throw new IllegalArgumentException();
    }
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[] dp = new int[n];
    dp[0] = obstacleGrid[0][0] != OBSTACLE ? 1 : 0;
    for (int i = 0;i < m;i++) {
        for (int j = 0;j < n;j++) {
            if (obstacleGrid[i][j] != OBSTACLE) {
                dp[j] += j > 0 ? dp[j - 1] : 0;
            } else {
                dp[j] = 0;
            }
        }
    }
    return dp[n - 1];
}