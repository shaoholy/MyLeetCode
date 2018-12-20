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

    //binary search 
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1; 
        } else if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1; 
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (getPrev(nums, mid) && getNext(nums, mid)) {
                return mid; 
            } else if (getPrev(nums, mid)) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    //support methods
    private boolean getPrev(int[] nums, int pos) {
        return pos == 0 ? true : nums[pos] > nums[pos - 1]; 
    }
    private boolean getNext(int[] nums, int pos) {
        return pos == nums.length - 1 ? true : nums[pos] > nums[pos + 1]; 
    }