package Leetcode2;

public class TwoSevenNine {

}
//1, 1D dp
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=n; i++){
            int min=Integer.MAX_VALUE;
            int j=1;
        	while(i - j*j >= 0) {
			min = Math.min(min, dp[i - j*j] + 1);
			++j;
		}
		dp[i] = min;
            
        }
        return dp[n];

    }
}
//2, bfs
public int numSquares(int n) {
      Queue<Integer> q=new LinkedList<Integer>();
      int count=0;
      q.add(n);
      while(q.size()!=0){
          count++;
          int len=q.size();
          for(int i=0; i<len; i++){
              int cur=q.poll();
              int j=1;
              while(cur-j*j>=0){
                  int nextint=cur-j*j;
                  if(nextint==0) return count;
                  q.add(nextint);
                  j++;
              }
          }
      }
      return 0;
}
