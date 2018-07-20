package Leetcode2;

public class Eight {

}
//trim() + iteration + string parse
class Solution {
    public int myAtoi(String str) {
        int sig=1;
        long lres=0;
        str=str.trim();
        if(str==null || str.length()==0) return 0;
        if(Character.isDigit(str.charAt(0)) || str.charAt(0)=='-' || str.charAt(0)=='+'){
            int start=0, end=0;
            if(str.charAt(0)=='-' || str.charAt(0)=='+'){
                sig= str.charAt(0)=='-'? -1:1;
                start++;
                if(start>=str.length() || !Character.isDigit(str.charAt(start))) return 0;
            }
            if(str.charAt(start)=='0'){
                while(start<str.length() && str.charAt(start)=='0') start++;
                if(start>=str.length() || !Character.isDigit(str.charAt(start))) return 0;
            }
            end=start;
            while(end<str.length() && Character.isDigit(str.charAt(end)) && end-start<=11) end++;
            lres=Long.parseLong(str.substring(start,end))*sig;
            if(lres>Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            else if(lres<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else return (int)lres;
        }else
        return 0;
    }
}
//pop + push
class Solution {
    public int myAtoi(String str) {
        int sig=1,res=0,start=0;
        str=str.trim();
        if(str==null || str.length()==0) return 0;
        
        if(str.charAt(start)=='-' ||str.charAt(start)=='+'){
            sig= str.charAt(start)=='-'? -1:1;
            start++;
        }
        
        while(start<str.length() && Character.isDigit(str.charAt(start))){
            if(res>Integer.MAX_VALUE/10 || res==Integer.MAX_VALUE/10 && str.charAt(start) - '0' > 7){
                return sig==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            
            res=res*10+(str.charAt(start++)-'0');
        }
        return sig*res;
    }
}