package Leetcode;

public class ThreeThree {

}
//binary search
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int aside=nums[nums.length-1],bside=nums[0], start=0, end = nums.length-1;
        
        while(start<end){
            if(target>aside && target<bside) return -1;
            int mid=start+(end-start)/2;
            if(target==nums[mid]) return mid;
            
            
            if(bside<aside){
                if(target>nums[mid]) start=mid+1;
                else end=mid-1;
            }else{
                if(target==aside) return end;
                if(target==bside) return start;
                if((target>bside&&target<nums[mid]) || (nums[mid]<bside&&target>bside) ||(nums[mid]<bside && nums[mid]>target)){
                    end=mid-1;
                    aside=nums[mid-1];
                }else{
                    start=mid+1;
                    bside=nums[mid+1];
                }
            }
        }
        return nums[start]==target? start:-1;
    }
}
//method2: 
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int min=getmin(nums);
        
        if(target<nums[0] && target>nums[nums.length-1]) return -1;
        else if(target<=nums[nums.length-1]) return bs(nums, min, nums.length-1, target);
        else return bs(nums, 0, min-1, target);
        
    }
    private int getmin(int[] nums){
        int start=0, end=nums.length-1, bside=nums[start], aside=nums[end];
        if(bside<=aside) return start;
        while(end-start>1){
            int mid=start+(end-start)/2;
            if(nums[mid]>bside){
                start=mid;
                bside=nums[mid];
            }else if(nums[mid]<aside){
                end=mid;
                aside=nums[mid];
            }
        }
        return end;
    }
    private int bs(int[] nums, int start, int end, int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return nums[start]==target? start:-1;
    }
}