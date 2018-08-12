package Leetcode2;

public class TwoOneThree {

}
//1, 1d dp, O(N) time, O(N) space 
// 6个参数：0，2分别为不带、带当前位的最大结果； 1，3分别为当前最大结果是否带nums[0]； 4，5分别为从nums[1]开始的、不带、带当前位的最大结果。
public int rob(int[] nums) {
    if(nums==null || nums.length==0) return 0;
    int[][] dp=new int[nums.length][6];
    dp[0][0]=0;
    dp[0][1]=0;
    dp[0][2]=nums[0];
    dp[0][3]=1;
    dp[0][4]=0;
    dp[0][5]=0;
    if(nums.length==1) return dp[0][2];
    for(int i=1; i<nums.length; i++){
        dp[i][0]=Math.max(dp[i-1][0], dp[i-1][2]);
        if(dp[i-1][0]>dp[i-1][2]) dp[i][1]=dp[i-1][1];
        else dp[i][1]=dp[i-1][3];
        dp[i][2]=dp[i-1][0]+nums[i];
        dp[i][3]=dp[i-1][1];
        dp[i][4]=Math.max(dp[i-1][4], dp[i-1][5]);
        dp[i][5]=nums[i]+dp[i-1][4];
    }
    
    if(dp[nums.length-1][0]>=dp[nums.length-1][2]) return dp[nums.length-1][0];
    else if(dp[nums.length-1][3]==0){
        return dp[nums.length-1][2];
    }else{
        return Math.max(Math.max(dp[nums.length-1][4],dp[nums.length-1][5]),
                        Math.max(dp[nums.length-2][0], dp[nums.length-2][2]));
    }
}
//2, 1d dp,  O(N) time, O(1) space 
//四个参数分别为，rob1当前最大结果，rob1前一个最大结果（从1到倒数第2）； NotRob1当前最大结果，NotRob2前一个最大结果（从第2到最后一个）。
public int rob(int[] nums) {
    if(nums.length ==0)
        return 0;
    if(nums.length < 2){
        return nums[0];
    }
    int rob1Prev2 = nums[0];
    int rob1Prev1 = nums[0];
    int notRob1Prev2 = 0;
    int notRob1Prev1 = nums[1];
    
    for(int i = 2;i < nums.length; i++){
        if(i<nums.length-1){
        int res1 = Math.max(rob1Prev2 + nums[i],rob1Prev1);
        rob1Prev2 = rob1Prev1;
        rob1Prev1 = res1;}
        int res2 = Math.max(notRob1Prev2 + nums[i],notRob1Prev1);
        notRob1Prev2 = notRob1Prev1;
        notRob1Prev1 = res2;
    }
    return Math.max(notRob1Prev1,rob1Prev1);
}