package Leetcode2;

public class ThreeOneTwo {

}
//1, zhongdian: 1, use last one as the divide conquer point each loop;
//2, use a 2-D int array to record duplicate situation. 
//time O(N^3), space N^2


public int maxCoins(int[] nums) {
    int[] num=new int[nums.length+2];
    int n=1;
    for(int x: nums)
        if(x!=0) num[n++]=x;
    num[0]=num[n++]=1;
    
    int[][] memo=new int[n][n];
    return burst(num, memo, 0, n-1);
}
private int burst(int[] num, int[][] memo, int start, int end){
    if(start+1==end)
        return 0;
    if (memo[start][end] > 0) 
        return memo[start][end];
    int max=0;
    for(int i=start+1; i<end; i++){
        max=Math.max(max, num[start]*num[i]*num[end]+
                    burst(num, memo, start, i)+burst(num, memo, i, end));
    }
    memo[start][end]=max;
    return max;
}