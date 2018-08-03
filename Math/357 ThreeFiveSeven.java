package Leetcode2;

public class ThreeFiveSeven {

}
///1, permutation iteration, O(N)

public int countNumbersWithUniqueDigits(int n) {
    int res=1,idx=1;
    while(idx<=n){
        int roundres=9;
        for(int i=9; i>(9-idx+1); i--)
            roundres*=i;
        res+=roundres;
        idx++;
    }
    return res;
}

//2, dp ///zhongdian: 多一位还剩几种可能。

public int countNumbersWithUniqueDigits(int n) {
    if (n > 10) { //already more than 10, so only consider under n^10
        return 0;
    }  
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return 10;
    }
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 10;
    for (int i = 2; i <= n; i++) {
        ///zhongdian: 多一位还剩几种可能。
        dp[i] = dp[i-1] + (dp[i-1]-dp[i-2]) * (11-i);
    }
    return dp[n];
}