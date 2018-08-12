package Leetcode2;

public class NineOne {

}
//1, recursion, down to 1 or 2 length. time, O(N), space O(logN)
public int numDecodings(String s) {
    
    if(s==null || s.length()==0 || s.startsWith("0")) return 0; 
    if(s.length()==1) return 1; 
    if(s.length()==2){
        if(s.charAt(1)=='0')
            return s.charAt(0)-'0'>2? 0:1;
        else
            return Integer.parseInt(s)>26? 1:2; 
    }
    
    int idx=s.length()/2; 
    String str1=s.substring(0, idx);
    String str2=s.substring(idx);
    
    if(str2.startsWith("0")){
        if(str1.charAt(str1.length()-1)-'0' <= 2 && str1.charAt(str1.length()-1) != '0'){
            return (str1.length()==1? 1:numDecodings(str1.substring(0,str1.length()-1)))*
                numDecodings(str2.substring(1));
        }else {
            return 0;
        }
    }else if(str1.charAt(str1.length()-1) == '0' || str1.charAt(str1.length()-1)-'0' > 2 || 
      str1.charAt(str1.length()-1)-'0'==2 && str2.charAt(0)-'0'> 6 ){
        return numDecodings(str1)*numDecodings(str2);
    }else{
        return numDecodings(str1)*numDecodings(str2)+
            (str1.length()==1? 1:numDecodings(str1.substring(0,str1.length()-1)))*
            numDecodings(str2.substring(1, str2.length()));
    }
}

//2, 1D DP, O(N) time, O(N) Space. m[level] as the possibilities starting from level. Basically from right to left acumulation. 
class Solution {
    public int numDecodings(String s) 
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int[] m = new int[s.length()+1];
        Arrays.fill(m, -1);
        return numDecodings(s.toCharArray(), 0, m);
    }
    
    private int numDecodings(char[] array, int level, int[] m)
    {
        if(m[level] != -1)
        {
            return m[level];
        }
        if(level == array.length)
        {
            m[level] = 1;
            return 1;
        }
        int ways = 0;
        if(array[level] != '0')
        {
            ways += numDecodings(array, level + 1, m);
        }
        if(validEncoding(array, level))
        {
            ways += numDecodings(array, level + 2, m);
        }
        m[level] = ways;
        return ways;
    }
    
    private boolean validEncoding(char[] array, int start)
    {
        if(start + 1 >= array.length)
        {
            return false;
        }
        if(array[start] == '1')
        {
            return true;
        }
        if(array[start] == '2' && array[start+1] - '6' <= 0)
        {
            return true;
        }
        return false;
    }
}