package Leetcode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import javax.naming.directory.DirContext;

public class ThreeFiveThree {

}
//
public class SnakeGame {
	LinkedList<Position> snake;
	int height; 
	int width;
	int nextFidx;
	int[][] food; 
	int score = 1; 
	boolean gameOver = false; 
	HashMap<String, Integer[]> dir;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    public class Position{
		int row;
		int col; 
		public Position(int row, int col) {
			this.row = row; 
			this.col = col;
		}
    }
    
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<Position>();
        snake.add(new Position(0, 0));
        this.food = food; 
        nextFidx = 0; 
        this.height = height;
        this.width = width;
        dir = new HashMap<String, Integer[]>();
        dir.put("U", new Integer[]{-1, 0});
        dir.put("D", new Integer[]{1, 0});
        dir.put("L", new Integer[]{0, -1});
        dir.put("R", new Integer[]{0, 1});
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    		if(gameOver) {
    			return score;
    		}
        int nextR = snake.get(0).row + dir.get(direction)[0];
        int nextC = snake.get(0).col + dir.get(direction)[1];
        if (snake.contains(new Position(nextR, nextC)) || nextR < 0 || nextR >= height || nextC < 0 || nextC >= width) {
        		gameOver = true;
        		score = -1;
        		return score;
		}else if(nextR == food[nextFidx][0] && nextC == food[nextFidx][1]) {
			snake.addFirst(new Position(nextR, nextC));
			nextFidx ++;
			if(nextFidx >= food.length) {
				gameOver = true;
			}
			score = snake.size();
			return score;
		}else {
			snake.pollLast();
			snake.addFirst(new Position(nextR, nextC));
			return score; 
		}

    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */