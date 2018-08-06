package Leetcode2;

public class ThreeTwoTwo {

}
//1, dp, O(n*k) time; O(N) space
public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    int[] dp=new int[amount+1];
    Arrays.fill(dp, -1);
    dp[0]=0;
    for(int i=1; i<=amount; i++){
        int min=Integer.MAX_VALUE;
        for(int x: coins){
            if(i-x>=0 && dp[i-x]!=-1){
                min=Math.min(min, 1+dp[i-x]);
            }
        }
        dp[i]=min;
    }
    return dp[amount];
}