package Leetcode;

public class FourSeven {

}
//1, same as 46, except use hashset to accept results, to avoid duplicate results. Slow. 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<List<Integer>>();
        ArrayList<Integer> cur=new ArrayList<Integer>();
        bt47(cur, nums, res, new boolean[nums.length]);
        return new ArrayList<List<Integer>>(res);
    }
    private void bt47(List<Integer> cur, int[] nums, HashSet<List<Integer>> res, boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }else{
            for(int i=0; i<nums.length; i++){
                if(!used[i]){
                cur.add(nums[i]);
                used[i]=!used[i];
                bt47(cur, nums, res, used);
                used[i]=!used[i];
                cur.remove(cur.size()-1);}
            }
        }
    }
}
//based on 1, used one extra hashmap to avoid iteration over duplicate at same recursion level
class Solution {
    HashMap<Integer, List<Integer>> checkd;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        checkd=new HashMap<Integer, List<Integer>>();
        for(int i=0; i<nums.length; i++){
            checkd.putIfAbsent(nums[i], new ArrayList<Integer>());
            checkd.get(nums[i]).add(i);
        }

        
        
        ArrayList<Integer> cur=new ArrayList<Integer>();
        bt47(cur, nums, res, new boolean[nums.length]);
        return res;
    }
    private void bt47(ArrayList<Integer> cur, int[] nums, ArrayList<List<Integer>> res, boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }else{
            boolean[] dupli=new boolean[nums.length];
            for(int i=0; i<nums.length; i++){
                if(!used[i] && !dupli[i]){
                cur.add(nums[i]);
                used[i]=!used[i];
                bt47(cur, nums, res, used);
                used[i]=!used[i];
                cur.remove(cur.size()-1);
                for(int x: checkd.get(nums[i])) dupli[x]=true;
                }
            }
        }
    }
}

//using HashSet of key(skip dupli) as iteration at each level
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> checkd=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) checkd.put(nums[i], checkd.getOrDefault(nums[i],0)+1);
        bt47(new ArrayList<Integer>(), nums, res, checkd);
        return res;
    }
    private void bt47(ArrayList<Integer> cur, int[] nums, ArrayList<List<Integer>> res, HashMap<Integer, Integer> checkd){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }else{
            Set<Integer> curset=new HashSet<Integer>(checkd.keySet());
            for(int x: curset){
                cur.add(x);
                if(checkd.get(x)==1) checkd.remove(x);
                else checkd.put(x, checkd.get(x)-1);
                bt47(cur, nums, res, checkd);
                cur.remove(cur.size()-1);
                checkd.put(x, checkd.getOrDefault(x,0)+1);
            }
        }
    }
}
