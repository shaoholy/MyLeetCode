package Leetcode;

import java.util.ArrayList;

public class TwoOneSIx {

}
//bt, more conditions to limitations. 
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(n==0 || k<1 || k>9 || (19-k)*k/2<n) return res;
        bt216(n, 1, new ArrayList<Integer>(), res,k);
        return res;
    }
    private void bt216(int left, int startidx, ArrayList<Integer> cur, List<List<Integer>> res, int k){
    	if(cur.size()>k || left<0) return;
        if(left==0 && cur.size()==k) {
        		res.add(new ArrayList<Integer>(cur));
        		return; 
        }
        if(startidx>9 || left<startidx) return; 
        for(int i=startidx; i<=9 && cur.size()<k; i++) {
        		cur.add(i);
        		bt216(left-i, i+1, cur, res,k);
        		cur.remove(cur.size()-1);
        }
    }
}
