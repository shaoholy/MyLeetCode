package Leetcode;

public class FourZero {

}
//same as 39, simpler
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        bt40(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void bt40(int[] nums, int left, int startidx, ArrayList<Integer> cur, List<List<Integer>> res){
        if(0==left){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if(startidx>=nums.length) return;
        if(nums[startidx]>left) return; 
        for(int i=startidx; i<nums.length; i++){
                cur.add(nums[i]);
                bt39(nums, left-nums[i], i+1, cur,res);
                cur.remove(cur.size()-1);
        }
    }

}
