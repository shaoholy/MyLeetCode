package Leetcode;

public class OneSixTwo {

}
// recursion O(logN) zhongdian: to make sure beyond-end<new end.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) return -1;
        return dfsFP(nums, 0, nums.length-1);
            
        }
        private int dfsFP(int[] nums, int start, int end){
            if(start==end) return start;
            if(end-start==1) return nums[start]>nums[end]? start:end;
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]<nums[mid-1]) return dfsFP(nums, start, mid-1);
            else return dfsFP(nums, mid+1, end);
        }
    }