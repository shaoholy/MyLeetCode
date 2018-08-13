package Leetcode2;

public class TwoEight {

}
//1, Rabin Karp O(N)
public int strStr(String haystack, String needle) {
    if(haystack == null || needle == null || haystack.length() < needle.length()){
        return -1;
    }
    if(needle.equals("")){
        return 0; 
    }
    
    int mode = 1000001; 
    int matchCode = 0, curCode = 0, power = 1; 
    for(int i = 0; i < needle.length(); i++ ){
        matchCode = (matchCode * 31 + (needle.charAt(i))) % mode; 
        power = (power * 31) % mode;
    }
    
    for(int i = 0; i < haystack.length(); i++){
        curCode = (curCode * 31 + haystack.charAt(i)) % mode;
        //System.out.println(i); 
        if(i >= needle.length()){
            curCode = curCode - power * haystack.charAt(i - needle.length()) % mode;
            if(curCode < 0){
                curCode += mode; 
            }
        }
        
        if(i >= needle.length() - 1){
            if(matchCode == curCode && 
               needle.equals(haystack.substring(i + 1 - needle.length(), i + 1))){
                //System.out.println(haystack.substring(i + 1 - needle.length(), i + 1));
                return i + 1 - needle.length();
            }
        }
    }
    return -1; 
}

//2, O(N^M) enumeration 
public int strStr(String haystack, String needle) {
    if(needle.equals("")) return 0;
    for(int i=0; i<haystack.length(); i++){
        if(haystack.charAt(i)==needle.charAt(0)){
            if(needle.length()==1) return i;
            int k=i+1,p=1;
            while(p<needle.length() && k<haystack.length()){
                if(needle.charAt(p)!=haystack.charAt(k)) break;
                else if(p==needle.length()-1) return i;
                k++;
                p++;
            }
        }
    }
    return -1;
}