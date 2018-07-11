package Leetcode;

public class EightOne {

}
//brutal judgement, one exceptionl mid=end=start: end--/start++. o(n) in worst case. generally o(logN)
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int start=0, end=nums.length-1; 
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return true;
            
            if(nums[mid]<nums[end] || nums[mid]<nums[start]){
                if(target>nums[mid] && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            else if(nums[mid]>nums[end] || nums[mid]>nums[start]){
                if(target<nums[mid] && target>=nums[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                end--;
            }
        }
        return false;
    }
}