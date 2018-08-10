package Leetcode2;

public class EightFive {

}
//1, dp, O(M*N) time, O(N) space, 
//zhongdian: [right(i,j) - left(i,j)]*height(i,j), from the last row. 

public int maximalRectangle(char[][] matrix) {
    if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int res=0;
    int[][] dp=new int[matrix[0].length][3];
    for(int i=0; i<matrix[0].length; i++){
        dp[i][0]=0;
        dp[i][1]=matrix[0].length;
        dp[i][2]=0;
    }
    
    for(int i=0; i<matrix.length; i++){
        int curleft=0, curright=matrix[0].length-1;
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j]=='1'){
                dp[j][2]++;
                dp[j][0]=Math.max(dp[j][0], curleft);
            }else {
                dp[j][2]=0;
                dp[j][0]=0;
                curleft=j+1;    
            }
        }
        
        for(int j=matrix[0].length-1; j>=0; j--){
            if(matrix[i][j]=='1'){
                dp[j][1]=Math.min(dp[j][1], curright);
            }else{
                dp[j][1]=matrix[0].length-1;
                curright=j-1;
            }
            //System.out.println((1+dp[j][1]-dp[j][0])*dp[j][2]+" i "+i+" j "+j);
            res=Math.max(res, (1+dp[j][1]-dp[j][0])*dp[j][2]);
        }
        
    }
    return res;
}