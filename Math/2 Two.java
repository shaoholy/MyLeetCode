package Leetcode2;

public class Two {

}
//1 hashmap o(n) time, o(n) space
class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> hmap=new HashMap<Integer, Integer>();
    for(int i=0;i<nums.length;i++){
        if(hmap.containsKey(target-nums[i])){
            return new int[]{hmap.get(target-nums[i]),i};
        }
        hmap.put(nums[i],i);
    }
        return null;
    }
}