package Leetcode2;

public class Seven {

}
//StringBuilder, Integer.toString(), Integer.parseInt(type name = new type();
//zhongdian: if(sb.length()==9 && i>0 && (Integer.parseInt(new String(sb)))>(Integer.MAX_VALUE)/10) return 0;
class Solution {
    public int reverse(int x) {
        int sig= x==Math.abs(x)? 1:-1;
        String mid=Integer.toString(Math.abs(x));
        StringBuilder sb=new StringBuilder();
        for(int i=mid.length()-1; i>=0; i--){
            sb.append(mid.charAt(i));
            if(sb.length()==9 && i>0 && (Integer.parseInt(new String(sb)))>(Integer.MAX_VALUE)/10) return 0;
        }
        return sig*Integer.parseInt(new String(sb));
    }
}
//push and pop iteration
class Solution {
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            res*=10;
            res+=x%10;
            x/=10;
            if(x!=0 && Math.abs(res)>Integer.MAX_VALUE/10) return 0;
        }
        return res;
    }
}

//use long as the initial res, 略
