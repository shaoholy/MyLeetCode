package Leetcode2;

public class OneSixSeven {

}
//1, hashmap, same as 1-two sum
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i]))
                return new int[]{map.get(target-numbers[i])+1, i+1};
            else 
                map.put(numbers[i], i);
                //new int[]{i, map.get(target-numbers[i-1])};i>map.get(target-numbers[i-1])? 
        }
        return null; 
    }
}

//2, two pointer end to mid

public int[] twoSum(int[] nums, int target) {
    int l=0, r=nums.length-1;
    while(l<r){
        int sum=nums[l]+nums[r];
        if(sum==target){
            return new int[]{l+1, r+1};
        }else if(sum<target){
            l++;
        }else{
            r--;
        }
    }
    return new int[]{0,0};
}

//3, two pointers, left to right; 

public int[] twoSum(int[] numbers, int target) {
    int right=1, left=0;
    while(right<numbers.length){
        if(numbers[right]+numbers[left]==target){
            return new int[]{left+1, right+1};
        }else if(numbers[right]+numbers[left]<target){
            right++;
            left++;
        }else{
            while(left>=0 && numbers[right]+numbers[left]>target ){
                left--;
            }
            if(numbers[right]+numbers[left]<target){
                left++;
                right++;
            }
        }
    }
    return null;
}
