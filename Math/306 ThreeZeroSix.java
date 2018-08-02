package Leetcode2;

public class ThreeZeroSix {

}
//1, dfs. Zhongdian: length limit to save time. avoid 0-start number. 
class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num==null || num.length()<3) return false; 
        int len=num.length();
        for(int i=2; i<=(int)(len/3)*2; i++){
            String curstr=num.substring(0,i);
            for(int j=1; j<i; j++){
                String pre2=curstr.substring(0,j);
                String pre1=curstr.substring(j);
                if(pre2.length()>num.substring(i).length() || pre1.length()>num.substring(i).length() 
                  || pre1.length()>1&&pre1.charAt(0)=='0' || pre2.length()>1&&pre2.charAt(0)=='0' )
                    continue;
                if(dfs(num, i, Long.parseLong(pre1),Long.parseLong(pre2))) 
                    return true;
            }
        }
        return false; 
    }
    private boolean dfs(String num, int posi, long pre1, long pre2){
        if(posi==num.length()) return true; 
        int len=Long.toString(pre1+pre2).length();
        if(posi+len>num.length()) return false;
        long cur=Long.parseLong(num.substring(posi, posi+len));
        if(cur==(pre1+pre2)){
            if(dfs(num, posi+len, cur,pre1)) return true;
        }
        return false;
    }
}