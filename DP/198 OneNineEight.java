package Leetcode2;

public class OneNineEight {

}
//1, 1D, DP, O(N) time and space. 
public int rob(int[] nums) {
    if(nums==null || nums.length==0) return 0;
    int res=nums[0];
    //[0]是当前为止最大的res，[1]为res是否包含当前位置的数字
    int[][] dp=new int[nums.length][2];
    dp[0][0]=nums[0];
    dp[0][1]=1;
    for(int i=1; i<nums.length; i++){
        if(dp[i-1][1]==0){
            dp[i][1]=1;
            dp[i][0]=dp[i-1][0]+nums[i];
        }else{
            int posi1=dp[i-1][0]-nums[i-1]+nums[i];
            int posi2=i>1? dp[i-2][0]+nums[i] : nums[i];
            int posi3=dp[i-1][0];
            if(posi3>=posi1 && posi3>=posi2){
                dp[i][0]=posi3;
                dp[i][1]=0;
            }else{
                dp[i][1]=1;
                dp[i][0]=Math.max(posi1, posi2);
            }
        }
        res=Math.max(res, dp[i][0]);
        //System.out.println(dp[i][0]+" i "+i);
    }
    return res;
}

//2, improved, o(1), one int as included, one as not included
public int rob(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
        int temp = prevNo;
        prevNo = Math.max(prevNo, prevYes);
        prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
}