package Leetcode2;

public class ThreeZeroOne {

}
//recur from both sides
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<String>();
        //int gap=posct-negct;
        bt301(s, res,  0, 0, new char[]{'(',')'});
        return res;
    }
    private void bt301(String s, List<String> res, int lasti, int lastj, char[] par){
        int count=0;
        for(int i=lasti; i<s.length(); ++i){
            if(s.charAt(i)==par[0]) count++;
            if(s.charAt(i)==par[1]) count--;
            if(count>=0) continue;
            //if count<0, recur all the inconnected')' removed Strings
            
            for(int j=lastj; j<=i;++j){
                if(s.charAt(j)==par[1] && (j==lastj || s.charAt(j-1)!=par[1]))
                    bt301(s.substring(0, j)+s.substring(j+1), res, i, j, par);
            }
            return;
        }
        
        String rev=new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            bt301(rev, res, 0,0, new char[]{')','('});
        else
            res.add(rev);
    }
}