package Leetcode;

public class OneFiveFour {

}
//zhongdian: 首尾去重；
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1] || nums.length==1) return nums[0];
        int start=0,end=nums.length-1;
        if(nums[0]==nums[nums.length-1]){
            while(end-1>=0 && nums[start]==nums[end]) end--;
            if(end==0 || nums[end]>nums[start]) return nums[0];
        }
        while(end-start>1){
            int mid=start+(end-start)/2;
            if(nums[mid]>=nums[start]) start=mid;
            else end=mid;
        }
        return nums[end];
    }
}