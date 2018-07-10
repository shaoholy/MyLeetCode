package Leetcode;

public class NineZero {

}
//normal backtrack, use hashset to avoid duplicates
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedHashSet<List<Integer>> res=new LinkedHashSet<List<Integer>>();
        Arrays.sort(nums);
        bt90(nums, 0, res, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(res);
    }
    private void bt90(int[] nums, int startidx, LinkedHashSet<List<Integer>> res,List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i=startidx; i<nums.length; i++){
            cur.add(nums[i]);
            bt90(nums, i+1, res, cur);
            cur.remove(cur.size()-1);
        }
    }
}
//iteration with hash to avoid duplicates
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        
        for(int x:nums){
            HashSet<List<Integer>> temp=new HashSet<List<Integer>>();
            for(List<Integer> list: res){
                ArrayList<Integer> newlist=new ArrayList(list);
                newlist.add(x);
                temp.add(newlist);
            }
            res.addAll(temp);
        }
        
        return new ArrayList<List<Integer>>(res);
    }
}