package Leetcode2;

import java.util.HashMap;

public class ThreeFourEight {

}

public class TicTacToe {
	int n; 
	HashMap<Integer, Integer> p1rows; 
	HashMap<Integer, Integer> p1cols; 
	HashMap<Integer, Integer> p2rows; 
	HashMap<Integer, Integer> p2cols; 
	int[] diag;
	int[] adiag;
	
 
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
    		this.n = n; 
    		p1rows = new HashMap<Integer, Integer>();
    		p1cols = new HashMap<Integer, Integer>();
    		p2rows = new HashMap<Integer, Integer>();
    		p2cols = new HashMap<Integer, Integer>();
    		diag = new int[2];
    		adiag = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    		HashMap<Integer, Integer> curR = player == 1? p1rows : p2rows;
    		HashMap<Integer, Integer> curC = player == 1? p1cols : p2rows;
    		HashMap<Integer, Integer> otherR = player == 1? p2rows : p1rows;
    		HashMap<Integer, Integer> otherC = player == 1? p2cols : p1cols;
    	
    
    		if(otherR.containsKey(row)) {
    			curR.put(row, -1);
    			otherR.put(row, -1);
    		}else {
    			curR.put(row, curR.getOrDefault(row, 0) + 1);
    			if(curR.get(row) == n) {
    				return player;
    			}
    		}
    		if(otherC.containsKey(col)) {
    			curC.put(col, -1);
    			otherC.put(col, -1);
    		}else {
    			curC.put(col, curC.getOrDefault(col, 0) + 1);
    			if(curC.get(col) == n) {
    				return player;
    			}
    		}
    		if(col == row) {
    			if(diag[0] == player) {
    				diag[1]++;
    				if(diag[1] == n) {
    					return player;
    				}
    			}else if(diag[0] == 0) {
    				diag[0] = player;
    			}else {
    				diag[0] = -1;
    			}
    		}
    		if(col + row == n - 1) {
    			if(adiag[0] == player) {
    				adiag[1]++;
    				if(adiag[1] == n) {
    					return player;
    				}
    			}else if(adiag[0] == 0) {
    				adiag[0] = player;
    			}else {
    				adiag[0] = -1;
    			}
    		}
    		return 0;
    }
}
//2, simplified
public class TicTacToe {
    private int[][] rows;
    private int[][] cols;
    private int[] diag = new int[2];
    private int[] adiag = new int[2];
    private int size;
 
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n][2];
        cols = new int[n][2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row][player-1] ++;
        if (rows[row][player-1] == size) return player;
        cols[col][player-1] ++;
        if (cols[col][player-1] == size) return player;
        if (row == col) {
            diag[player-1] ++;
            if (diag[player-1] == size) return player;
        }
        if (row+col==size-1) {
            adiag[player-1] ++;
            if (adiag[player-1] == size) return player;
        }
        return 0;
    }
}


