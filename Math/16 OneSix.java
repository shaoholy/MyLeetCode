package Leetcode2;

public class OneSix {

}
//1, iteration time: o(n^2)
public int threeSumClosest(int[] nums, int target) {
    int res=0, mingap=Integer.MAX_VALUE; 
    if(nums.length<3) return mingap;
    Arrays.sort(nums);
    if(nums[0]>=0 && target<=0) return nums[0]+nums[1]+nums[2];
    if(nums[nums.length-1]<=0 && target>=0) 
        return nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
    for(int i=0; i<nums.length; i++){
        if(nums[i]>=0 && nums[i]-target>=mingap) break;
        if(i>0 && nums[i]==nums[i-1]) continue;
        int left=i+1,right=nums.length-1;
        while(left<right){
            int sum=(nums[left]+nums[right])+nums[i];
            if(mingap>Math.abs(target-sum)){
                res=sum;
                mingap=Math.abs(target-sum);
            }
            if(mingap==0) return target;
            if(target-sum>0) left++;
            else right--;
        }
    }
    return res;
}