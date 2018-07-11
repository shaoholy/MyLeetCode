package Leetcode;

public class ThreeNine {

}
//backtracking with possible duplicate each time;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        bt39(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
        
    }
    private void bt39(int[] nums, int left, int startidx, ArrayList<Integer> cur, List<List<Integer>> res){
        if(0==left){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if(startidx>=nums.length) return;
        if(nums[startidx]>left) return; 
        for(int i=startidx; i<nums.length; i++){
            int times=left/nums[i];
            for(int j=1;j<=times; j++){
                cur.add(nums[i]);
                left-=nums[i];
                bt39(nums, left, i+1, cur,res);}
            for(int j=1;j<=times; j++){
                cur.remove(cur.size()-1);
                left+=nums[i];}
        }
    }
}