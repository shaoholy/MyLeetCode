package Leetcode2;

public class OneSevenFour {

}
//bottom-up DP, 2-D, time & space O(M*N)
public int calculateMinimumHP(int[][] dungeon) {
    if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 1;
    //第三维度0表示到达当前所需最小初始health， 1表示到达当前后剩余health
    int[][][] dp=new int[dungeon.length][dungeon[0].length][2];
    for(int i=dungeon.length-1; i>=0; i--){
        for(int j=dungeon[0].length-1; j>=0; j--){
            if(i==dungeon.length-1 && j==dungeon[0].length-1){
                dp[i][j][0]=dungeon[i][j]<0? 1-dungeon[i][j]:1; 
                dp[i][j][1]=dungeon[i][j]<0? 1:1+dungeon[i][j];
            }else{
                int below= i==dungeon.length-1? Integer.MAX_VALUE: 
                    dungeon[i][j]<0? dp[i+1][j][0]-dungeon[i][j]: 
                    dungeon[i][j]-dp[i+1][j][0]>=0? 1:dp[i+1][j][0]-dungeon[i][j];
                        
                int right= j==dungeon[0].length-1? Integer.MAX_VALUE:
                    dungeon[i][j]<0? dp[i][j+1][0]-dungeon[i][j]:
                    dungeon[i][j]-dp[i][j+1][0]>=0? 1:dp[i][j+1][0]-dungeon[i][j];
                if(below<right){
                    dp[i][j][0]=below; 
                    dp[i][j][1]=below+dungeon[i][j];
                }else{
                    dp[i][j][0]=right;
                    dp[i][j][1]=right+dungeon[i][j];
                }
            }
        }
    }
    return dp[0][0][0]; 
}
//2, simplified, 2-D is ok, only entry-health is needed
public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    
    int m = dungeon.length;
    int n = dungeon[0].length;
    
    int[][] health = new int[m][n];

    health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

    for (int i = m - 2; i >= 0; i--) {            
        health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
    }

    for (int j = n - 2; j >= 0; j--) {
        health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
    }

    for (int i = m - 2; i >= 0; i--) {
        for (int j = n - 2; j >= 0; j--) {
            int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
            int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
            health[i][j] = Math.min(right, down);
        }
    }

    return health[0][0];
}