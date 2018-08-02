package Leetcode2;

public class TwoNineTwo {

}
///1, 1-D dp. O(N) time, O(N) space
public boolean canWinNim(int n) {
    if(n<=3) return true;
    boolean[] dp=new boolean[n+1];
    for(int i=0; i<=3; i++) 
        dp[i]=true; 
    
    for(int i=4; i<=n; i++){
        for(int j=i-1; j>=i-3; j--){
            if(!dp[j]){
                dp[i]=true;
                break;
            }
        }
    }
    return dp[n];
}
//2 simplified
public boolean canWinNim(int n) {
    return n % 4 != 0;
}