package Leetcode2;

import javax.swing.text.Highlighter.Highlight;

public class ThreeZeroTwo {

}
//1, binarySearch
//zhongdian: use a boolean to judge findFistNonBlack or FirstBlack
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        // write your code here
    		if(image == null || image.length == 0 || image[0].length == 0) {
    			return -1;
    		}
    		int left = searchHelper(image, 0, y, 0, image.length, false, true);
    		int right = searchHelper(image, y + 1, image[0].length, 0, image.length - 1, false, false);
    		int up = searchHelper(image, 0, x, left, right, true, true);
    		int down = searchHelper(image, x + 1, image.length, left, right, true, false); 
    		return (right - left) * (down - up);
    }
    private int searchHelper(char[][] image, int low, int high, int min, int max, boolean searchHori, boolean searchBlack) {
    		while(low < high) {
    			int mid = low + (high - low) / 2;
    			boolean hasBlack = false;
    			for(int i = min; i < max; i++) {
    				char cur = searchHori? image[mid][i] : image[i][mid];
    				if(cur == '1') {
    					hasBlack = true;
    					break; 
    				}
    			}
    			if(searchBlack == hasBlack) {
    				high = mid;
    			}else {
    				low = mid + 1;
    			}
    		}
    		return low;
    }
}