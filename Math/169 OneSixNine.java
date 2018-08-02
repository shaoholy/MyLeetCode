package Leetcode;

public class OneSixNine {

}
//moore voting
class Solution {
    public int getmajority(int[] nums) {
        int num,count=0;
        for(int x: nums) {
        		if(count==0) {
        			num=x;
        		}
        		if(x==num) count++;
        		if(x!=num) {
        			count--;
        		}
        }
        return num;
    }
}
