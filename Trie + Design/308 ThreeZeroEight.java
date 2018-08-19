package Leetcode2;

import java.awt.image.RescaleOp;

public class ThreeZeroEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//1, n * logM for update & regionSum
public class NumMatrix {
    int[][] n;
    int[][] BIT; 
    
    public NumMatrix(int[][] matrix) {
    		n = matrix;
    		BIT = new int[n.length][n[0].length+1];
    		for(int i = 0; i < BIT.length; i++) {
    			for(int j = 0; j < BIT[0].length - 1; j++) {
    				int start = j + 1; 
    				while(start < BIT[0].length) {
    					BIT[i][start] += matrix[i][j - 1];
    					start += (start & -start);
    				}
    			}
    		}
    }
    
    public void update(int row, int col, int val) {
        int gap = val - n[row][col];
        n[row][col] = val; 
        int start = col + 1; 
        while(start < BIT[0].length) {
        		BIT[row][start] += gap;
        		start += (start & -start);
        }
        
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
    		int res = 0; 
    		for( int i = row1; i <= row2; i++) {
    			res += getSum(i, col2, BIT) - getSum(i, col1 - 1, BIT);
    		}
    		return res; 
    }
    
    private int getSum(int row, int i, int[][] BIT) {
    		int res = 0;
    		i++;
    		while(i >= 0) {
    			res += BIT[row][i];
    			i -= (i & -i);
    		}
    		return res; 
    }
}

//2, to one line,O(log N*M) time for both op
public class NumMatrix {
  int[][] n;
  int[] BIT; 
  
  public NumMatrix(int[][] matrix) {
	n = matrix;
	BIT = new int[n.length * n[0].length +1];
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix[0].length; j++) {
			int start = i * matrix.length + j + 1; 
			while(start < BIT.length) {
				BIT[i][start] += matrix[i][j - 1];
				start += (start & -start);
			}
		}
	}
  }
  
  public void update(int row, int col, int val) {
      int gap = val - n[row][col];
      n[row][col] = val; 
      int start = row * n.length + col + 1; 
      while(start < BIT.length) {
      		BIT[start] += gap;
      		start += (start & -start);
      }
  }
  public int sumRegion(int row1, int col1, int row2, int col2) {
  		int res = 0; 
  		for( int i = row1; i <= row2; i++) {
  			res += getSum(i * n.length + col2, BIT) - getSum(i * n.length + col1, BIT);
  		}
  		return res; 
  }
  
  private int getSum(int i, int[] BIT) {
  		int res = 0;
  		i++;
  		while(i >= 0) {
  			res += BIT[i];
  			i -= (i & -i);
  		}
  		return res; 
  }
}
