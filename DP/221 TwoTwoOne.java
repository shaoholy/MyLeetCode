package Leetcode2;

public class TwoTwoOne {

}
//1, simplified, o(m*n) solution, 1, one extra layer; 2, compare left, up, up-left; 

public int maximalSquare(char[][] a) {
    if(a.length == 0) return 0;
    int m = a.length, n = a[0].length, result = 0;
    int[][] b = new int[m+1][n+1];
    for (int i = 1 ; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if(a[i-1][j-1] == '1') {
              //zhongdian hang: compare up, left, and up-left, find min and +1
                b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                result = Math.max(b[i][j], result); // update result
            }
        }
    }
    return result*result;
}

//2,  2D DP, O(MN^2) time O(M*N)space

public int maximalSquare(char[][] matrix) {
    if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int res=0;
    int m=matrix.length, n=matrix[0].length;
    int[][] dp=new int[m][n];
    
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(i-1<0 || j-1<0){
                dp[i][j]= matrix[i][j]=='1'? 1:0;
            }else if(matrix[i][j]!='0' && dp[i-1][j-1]!=0){
                int k=1;
                for(; k<=dp[i-1][j-1]; k++)
                    if(matrix[i][j-k]!='1' || matrix[i-k][j]!='1'){
                        break;
                    }
                dp[i][j]=k;
            }else if(matrix[i][j]!='0' && dp[i-1][j-1]==0)
                dp[i][j]=1;
            res=Math.max(res, dp[i][j]*dp[i][j]);
        }
    }
    return res;
}