package Leetcode2;

public class SixFour {

}
//1, 2D bottom up dp
public int minPathSum(int[][] grid) {
    int[][] dp=new int[grid.length][grid[0].length];
    dp[grid.length-1][grid[0].length-1]=grid[grid.length-1][grid[0].length-1];
    for(int i=grid.length+grid[0].length-3; i>=0; i--){
        for(int j=grid.length-1; j>=0; j--){
            int k=i-j;
            if(k<0 || k>=grid[0].length) continue;
            if(j==grid.length-1){
                dp[j][k]=grid[j][k]+dp[j][k+1];
            }else if(k==grid[0].length-1){
                dp[j][k]=grid[j][k]+dp[j+1][k];
            }else{
                dp[j][k]=grid[j][k]+Math.min(dp[j+1][k], dp[j][k+1]);
            }
            //System.out.println(dp[j][k] +" j "+ j + " k "+k);
        }
    }
    return dp[0][0];
}
//2, 2D dp top to bottom, O(1) space
public int minPathSum(int[][] grid) {
	int m = grid.length;// row
	int n = grid[0].length; // column
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (i == 0 && j != 0) {
				grid[i][j] = grid[i][j] + grid[i][j - 1];
			} else if (i != 0 && j == 0) {
				grid[i][j] = grid[i][j] + grid[i - 1][j];
			} else if (i == 0 && j == 0) {
				grid[i][j] = grid[i][j];
			} else {
				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
						+ grid[i][j];
			}
		}
	}

	return grid[m - 1][n - 1];
}