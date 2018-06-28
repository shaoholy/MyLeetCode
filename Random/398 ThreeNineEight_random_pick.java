package Leetcode;

public class ThreeNineEight_random_pick {

}
class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        ArrayList<Integer> indexs=new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(target==nums[i]) indexs.add(i);
        }
        Random r=new Random();
        int j=r.nextInt(indexs.size());
        return indexs.get(j);
    }
}