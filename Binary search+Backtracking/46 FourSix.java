package Leetcode;

public class FourSix {

}
//backtracking, o(n!) time. used in boolean[] is faster than hashset
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> cur=new ArrayList<Integer>();
        bt46(cur, nums, res, new boolean[nums.length]);
        return res;
    }
    private void bt46(List<Integer> cur, int[] nums, List<List<Integer>> res, boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }else{
            for(int i=0; i<nums.length; i++){
                if(!used[i]){
                cur.add(nums[i]);
                used[i]=!used[i];
                bt46(cur, nums, res, used);
                used[i]=!used[i];
                cur.remove(cur.size()-1);}
            }
        }
    }
}
//iteration
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> cur=new ArrayList<Integer>();
        cur.add(nums[0]);
        res.add(cur);
        for(int i=1; i<nums.length; i++){
            ArrayList<List<Integer>> newres=new ArrayList<List<Integer>>();
            for(List<Integer> list: res){
                for(int j=0; j<=i; j++){
                    ArrayList<Integer> newcur=new ArrayList<Integer>(list);
                    newcur.add(j, nums[i]);
                    newres.add(newcur);
                }
            }
            res=newres;
        }
        return res;
    }

}