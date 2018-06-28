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

//better random method! no extra space!

public class Solution {

    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}```