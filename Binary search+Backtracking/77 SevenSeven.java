package Leetcode;

public class SevenSeven {

}
//backtracking
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res= new ArrayList<List<Integer>>();
        bt77(1,n,k,new ArrayList<Integer>(), res);
        return res;
    }
    private void bt77(int start, int end, int k, List<Integer> cur, List<List<Integer>> res){
        if(cur.size()==k) {
            res.add(new ArrayList<Integer>(cur));
            return;}
        for(int i=start; i<=end; i++){
            cur.add(i);
            bt77(i+1, end, k, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}