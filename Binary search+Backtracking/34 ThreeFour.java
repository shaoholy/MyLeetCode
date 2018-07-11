package Leetcode;

public class ThreeFour {

}
//1, find target-1 insert posi, 2, find target number.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int smalltarget=target-1;
        int[] res=new int[2];
        if(nums.length==0 || nums[nums.length-1]<target || nums[0]>target ) return new int[]{-1,-1};
        int res2=insertposi(nums, target-1);
        if(nums[res2]!=target) return new int[]{-1,-1};
        else{
            res[0]=res2;
            while(res2<nums.length && nums[res2]==target) res2++;
            res[1]=res2-1;
            return res;
        }
    }
    private int insertposi(int[] nums,int target){
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0]>target? 0:1;
        int start= 0, end= nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                while(mid<nums.length && nums[mid]==target) mid++;
                return mid;
            }else if(nums[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return nums[start]<=target? start+1:start;
    }
}

//2 pure recursion, class Solution , use recursion to find the begin and end of duplicate
public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if(nums == null || nums.length ==0)
        return result;
    
    int[] range = helper(nums, target, 0, nums.length-1);
    return range[0]==Integer.MAX_VALUE ? result : range;

}   

private int[] helper(int[] nums, int target, int start, int end){
    int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    while(start<=end){
        int mid = (start+end)/2;
        if(nums[mid]==target){
            result[0]=mid;
            result[1]=mid;
            result[0]=Math.min(result[0], helper(nums,target, start, mid-1)[0]);
            result[1]=Math.max(result[1], helper(nums,target, mid+1, end)[1]);
            return result;
        } else if(target>nums[mid]){
            start = mid+1;  
        } else {
            end = mid-1;
        }
    }
    return result;
        
}
