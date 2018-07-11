package Leetcode;

public class OneFiveThree {

}
//Iteration o(logN) time
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        int start=0, end=nums.length-1;
        while(end-start>1){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[start]) start=mid;
            else end=mid;
        }
        return nums[end];
    }
}

//recursion, same as one
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1]) return nums[0];
        
        return nums[dfs153(nums, 0, nums.length-1)];
    }
    private int dfs153(int[] nums, int start, int end){
        if(end-start==1) return end;
        int mid=start+(end-start)/2;
        if(nums[mid]>nums[start]) return dfs153(nums,  mid, end);
        else return dfs153(nums, start,mid);
    }
}