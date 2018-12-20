package Leetcode;

public class ThreeFive {

}
//O(logN) time. zhongdian: judge equal at the end 
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return nums[start]<target? start+1: start;
    }
}

//same but more concise
public int searchInsert(int[] A, int target) {
    int low = 0, high = A.length-1;
    while(low<=high){
        int mid = (low+high)/2;
        if(A[mid] == target) return mid;
        else if(A[mid] > target) high = mid-1;
        else low = mid+1;
    }
    return low;
}

//to handle duplicate(find first)
public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1; 
            } else if (nums[mid] > target) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return left; 
    }