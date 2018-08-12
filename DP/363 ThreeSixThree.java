package Leetcode2;

public class ThreeSixThree {

}
//1, 2-D DP, O(N^4) time
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res=Integer.MIN_VALUE; 
        int rows=matrix.length, cols=matrix[0].length; 
        int[][] areas=new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int area=matrix[i][j];
                if(i>0) area+=areas[i-1][j];
                if(j>0) area+=areas[i][j-1];
                if(i>0 && j>0) area-=areas[i-1][j-1];
                areas[i][j]=area;
            }
        }
        
        for(int r1=0; r1<rows; r1++){
            for(int c1=0; c1<cols; c1++){
                for(int r2=r1; r2<rows; r2++){
                    for(int c2=c1; c2<cols; c2++){
                        int sec=areas[r2][c2];
                        if(r1>0)  sec-=areas[r1-1][c2];
                        if(c1>0)  sec-=areas[r2][c1-1];
                        if(r1>0 && c1>0) sec+= areas[r1-1][c1-1];
                        if(sec<=k) res=Math.max(sec, res);
                    }
                }
            }
        }
        return res;
    }
    
//2, 2-D dp, O(N^3 * logN) time, use treeset to find left boundary each floor
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res=Integer.MIN_VALUE; 
        int rows=matrix.length, cols=matrix[0].length; 
        int[][] areas=new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int area=matrix[i][j];
                if(i>0) area+=areas[i-1][j];
                if(j>0) area+=areas[i][j-1];
                if(i>0 && j>0) area-=areas[i-1][j-1];
                areas[i][j]=area;
            }
        }
        
        for(int r1=0; r1<rows; r1++){
            for(int r2=r1; r2<rows; r2++){
                TreeSet<Integer> set=new TreeSet<Integer>();
                set.add(0);
                for(int c=0; c<cols; c++){
                    int sec=areas[r2][c];
                    if(r1>0) sec-= areas[r1-1][c];
                    Integer ceiling=set.ceiling(sec-k);
                    if(ceiling!=null)
                        res=Math.max(res, sec-ceiling);
                    set.add(sec);
                }
            }
        }
        return res;
    }
//3, simplified. 1, space use only one D, to store each loop; 2, judge col & row for directions
public int maxSumSubmatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if(row==0)return 0;
    int col = matrix[0].length;
    int m = Math.min(row,col);
    int n = Math.max(row,col);
    //indicating sum up in every row or every column
    boolean colIsBig = col>row;
    int res = Integer.MIN_VALUE;
    for(int i = 0;i<m;i++){
        int[] array = new int[n];
        // sum from row j to row i
        for(int j = i;j>=0;j--){
            int val = 0;
            TreeSet<Integer> set = new TreeSet<Integer>();
            set.add(0);
            //traverse every column/row and sum up
            for(int k = 0;k<n;k++){
                array[k]=array[k]+(colIsBig?matrix[j][k]:matrix[k][j]);
                val = val + array[k];
                //use  TreeMap to binary search previous sum to get possible result 
                Integer subres = set.ceiling(val-target);
                if(null!=subres){
                    res=Math.max(res,val-subres);
                }
                set.add(val);
            }
        }
    }
    return res;
}