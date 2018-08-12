package Leetcode2;

public class EightSeven {

}
//1, scramble. time  O(2^n)
public boolean isScramble(String s1, String s2) {
	if(s1.length()!=s2.length()) return false;
    if(s2.equals("") || s1.equals("")) return  false;
    int n=s1.length();
    int[] letters=new int[256];
    for(int i=0; i<s1.length(); i++){
        letters[s1.charAt(i)]++;
        letters[s2.charAt(i)]--;
    }
    
    for(int x: letters) if(x!=0) return false; 
    
	if( n==1) {
		return s1.equals(s2);
	}else {
        for(int i=1; i<s1.length(); i++){
            if(isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)) || 
              isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) return true; 
        }
	}
    return false; 
}