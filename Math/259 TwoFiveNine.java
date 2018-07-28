package Leetcode2;

import java.util.Arrays;

public class TwoFiveNine {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {-2, 0, 1, 3,4,6,9};
		TwoFiveNine TFN=new TwoFiveNine();
		System.out.println(TFN.threesumsmall(nums, 7));
	}
	
	public int threesumsmall(int[] nums, int target) {
		Arrays.sort(nums);
		int sum=0;
		for(int i=0; i<nums.length-2; i++) {
			int thissum=(nums.length-i-1)*(nums.length-i-2)/2;
			int left=i+1, right = nums.length-1;
			int minus=0;
			int leftnum=target-nums[i];
			while(left<right) {
				while(right>left && nums[left]+nums[right]>=leftnum) {
					right--;
					minus++;
				}
				thissum-=minus;
				left++;
			}
			thissum-=(nums.length-left)*(nums.length-left-1)/2;
			sum+=thissum;
		}
		return sum;
	}
}
//Arrays.sort
