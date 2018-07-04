package Leetcode;

import java.util.Stack;

public class TwoFiveFive {
    public static void main(String[] args) {
        int [] nums={10,5,2,6,12};
        System.out.println(verifyPreorde(nums));
    }
    public static boolean verifyPreorde(int[] nums){
        Stack<Integer> thestack=new Stack<Integer>();
        thestack.push(nums[0]);
        int min=Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++) {
        		if(nums[i]<min) return false;
        		if(nums[i]<thestack.peek()) thestack.push(nums[i]);
        		else if( nums[i]>thestack.peek()) {
        			while(thestack.size()!=0 && nums[i]>thestack.peek()) {
        				min=thestack.pop();
        			}
        			thestack.push(nums[i]);
        		}else return false;
        }
        return true;
    }
}