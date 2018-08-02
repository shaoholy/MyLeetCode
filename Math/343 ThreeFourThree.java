package Leetcode2;

public class ThreeFourThree {

}
//1, 3 as break
public int integerBreak(int n) {
    if(n<=7){
        return n/2 * (n-n/2);
    }
    if(n%3==1) return 4*integerBreak(n-4);
    else if(n%3==2) return 2*integerBreak(n-2);
    else{
        int round=n/3;
        return (int)Math.pow(3, round);
    }
}

//2, dp-recur,(O(N^2) time, O(N) space)

public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        return dphelper(2, n, dp);
    }
    private int dphelper(int cur, int n, int[] dp){
        if(cur>n) return dp[n];
        //two pointers from ends to middle, meaning adding up to targets, finding the largest max
        int left=1, right = cur-1, max=-1; 
        while(left<=right){
            int curmax=1;
            if(dp[left]>left) curmax*=dp[left];
            else curmax*=left;
            if(dp[right]>right) curmax*=dp[right];
            else curmax*=right;
            max=Math.max(max, curmax);
            left++;
            right--;
        }
        dp[cur]=max; 
        return dphelper(cur+1, n, dp);
    }

//3, dp-iteration, (O(N^2) time, O(N) space)
public int integerBreak(int n) {
    int[] dp=new int[n+1];
    dp[1]=1;
    for(int cur=2; cur<=n; cur++){
        int left=1, right = cur-1, max=-1;
        while(left<=right){
            int curmax=1;
            if(dp[left]>left) curmax*=dp[left];
            else curmax*=left;
            if(dp[right]>right) curmax*=dp[right];
            else curmax*=right;
            max=Math.max(max, curmax);
            left++;
            right--;
            }
        dp[cur]=max; 
    }
    return dp[n];
}