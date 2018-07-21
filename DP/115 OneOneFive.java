package Leetcode2;

public class OneOneFive {

}
//backtracking. not work, due to time exceed
class Solution {
    int res;
    public int numDistinct(String s, String t) {
        res=0;
        if(t==null || t.length()==0) return res;
        else if(s==null || s.length()==0) return res;
		bt115(s, t, -1,-1);
		return res;
    }
    private void bt115(String s, String t, int sposi, int tposi){
        if(tposi==t.length()-1){
            res++;
            return;
        }
        for(int i=sposi+1; i<(s.length()-(t.length()-tposi)+2); i++){
            if(s.charAt(i)==t.charAt(tposi+1)){
                bt115(s, t, i, tposi+1);
            }
        }
    }
}
//dp timeO(MN) spaceO(MN)
class Solution {
    int res;
    public int numDistinct(String s, String t) {
        res=0;
        if(t==null || t.length()==0) return res;
        else if(s==null || s.length()==0) return res;
		int[][] dp=new int[t.length()][s.length()];
        for(int i=0; i<t.length(); i++){
            for(int j=0; j<s.length(); j++){
                int upleft= (i-1>=0&&j-1>=0)? dp[i-1][j-1]:0;
                int left= (j-1>=0)? dp[i][j-1]:0;
                if(s.charAt(j)==t.charAt(i)){
                    if(i==0 ) dp[i][j]=1+left;
                    else dp[i][j]=upleft+left;
                }else dp[i][j]=left;
            }
        }
        return dp[t.length()-1][s.length()-1];
    }
}