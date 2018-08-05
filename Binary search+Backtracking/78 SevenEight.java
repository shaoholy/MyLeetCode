package Leetcode;

public class SevenEight {

}
//general backtracking: 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        ArrayList<Integer> cur= new ArrayList<Integer>();
        for(int i=0; i<=nums.length; i++){
            backtracking78(nums, 0, i, cur, res);
        }
        return res;
    }
    private void backtracking78(int[] nums, int startidx, int len, List<Integer> cur,List<List<Integer>> res){
        
        if(cur.size()==len){
            ArrayList<Integer> newlist=new ArrayList<Integer>(cur);
            res.add(newlist);
            return;
        }
        if(startidx>=nums.length) return; 
        
        for(int i=startidx; i<nums.length; i++){
            cur.add(nums[i]);
            backtracking78(nums, i+1, len, cur, res);
            cur.remove(cur.size()-1);
        } 
    }
}
//concise version(直接考虑所有长度) zhongdian: 每次backtrack add的都是一个shadow的新list！
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        ArrayList<Integer> cur= new ArrayList<Integer>();
        backtracking78(nums, 0,  cur, res);
        return res;
    }
    private void backtracking78(int[] nums, int startidx, List<Integer> cur,List<List<Integer>> res){
        res.add(new ArrayList<Integer>(cur));
        for(int i=startidx; i<nums.length; i++) {
        		cur.add(nums[startidx]);
        		backtracking78(nums, startidx+1, cur, res);
        		cur.remove(cur.size()-1);
        }
    }
}


//2, for each loop. zhongdian: use temp<List<integer>> and new list cur, to avoid ConcurrentModificationException
//time and space O(2^n)?
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i: nums){
            int len=res.size()
            for(int i=0; i<len; i++){
                List<Integer> cur=new ArrayList<Integer>(res.get(i));
                cur.add(i);
                res.add(temp);
            }
        }
        return res;
    }
}

//bit manipulation same as 2, C++ code
class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        sort (S.begin(), S.end());
        int elem_num = S.size();
        int subset_num = pow (2, elem_num);
        vector<vector<int> > subset_set (subset_num, vector<int>());
        for (int i = 0; i < elem_num; i++)
            for (int j = 0; j < subset_num; j++)
                if ((j >> i) & 1)
                    subset_set[j].push_back (S[i]);
        return subset_set;
    }
};