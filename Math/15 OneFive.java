package Leetcode2;

import java.util.Arrays;

public class OneFive {

}
//iteration  o(n^2) time.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums==null || nums.length==0 || nums[0]>0 || nums[nums.length-1]<0) return res;
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            helper(nums, i, 0-nums[i], res);
            if(nums[i]>0) break; 
        }
        return res;
    }
    
    private void helper(int[] nums, int posi, int leftnum, List<List<Integer>> res){
        int left=posi+1, right=nums.length-1; 
        while(left<right){
            if(nums[left]+nums[right]==leftnum){
                res.add(Arrays.asList(-leftnum, nums[left], nums[right]));
                while(left<right){
                    left++;
                    if(nums[left]!=nums[left-1]) break;
                }
                while(right>left){
                    right--;
                    if(nums[right]!=nums[right+1]) break;
                }
            }else if(nums[left]+nums[right]<leftnum){
                left++;
            }else{
                right--;
            }
        }
    }
}