package Leetcode2;

import javax.print.attribute.standard.RequestingUserName;

public class TwoFiveSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}
	//1, 2D dp O(N) time, o(N) space
//	public class Solution {
//	    public int minCost(int[][] costs) {
//	        int[][] dp=new int[costs[0].length][3];
//	        int res=Integer.MAX_VALUE;
//	        for(int i=0; i<3; i++)
//	        		dp[0][i]=costs[0][i];
//	        if(costs.length==1) {
//	        		return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//	        }
//	        for(int j=1; j<costs.length; j++) {
//	        		for(int i=0; i<3; i++) {
//	        			int min=Integer.MAX_VALUE;
//	        			for(int k=0; k<3; k++) {
//	        				if(k!=i) min=Math.min(min, costs[j][i]+dp[j-1][k]);
//	        				
//	        			}
//	        			dp[j][i]=min;
//	        			if(j==costs.length-1) res=Math.min(res, dp[j][i]);
//	        		}
//	        }
//	        return res;
//	    }
//	}
	
	//2, o(n) time, O(1) space
	public class Solution{
		public int minCost(int[][] costs) {
			int red=0, blue=0, green=0;
			for(int i=0; i<costs.length; i++) {
				int nr=costs[i][0]+ Math.min(blue, green);
				int nb=costs[i][1]+ Math.min(red, green);
				int ng=costs[i][2]+ Math.min(blue, red);
				red=nr;
				blue=nb;
				green=ng;
			}
			return Math.min(red, Math.min(blue, green));
		}
	}
	
	//3, 也可以使用取模的方法来实现内存优化（九章算法老师提供的方法）：
	public class Solution {
	    public int minCost(int[][] costs) {
	        int[][] total = new int[2][3];
	        for(int i=1; i<=costs.length; i++) {
	            total[i%2][0] = Math.min(total[(i-1)%2][1]+costs[i-1][0], total[(i-1)%2][2]+costs[i-1][0]);
	            total[i%2][1] = Math.min(total[(i-1)%2][0]+costs[i-1][1], total[(i-1)%2][2]+costs[i-1][1]);
	            total[i%2][2] = Math.min(total[(i-1)%2][0]+costs[i-1][2], total[(i-1)%2][1]+costs[i-1][2]);
	        }
	        return Math.min(total[costs.length%2][0], Math.min(total[costs.length%2][1], total[costs.length%2][2]));
	    }

}
