package Leetcode;

public class ThreeEightNine {

}
//int[] count 
class Solution {
    public char findTheDifference(String s, String t) {
        int[] count=new int[26];
        for(int i=0; i<t.length(); i++){
            count[t.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']--;
        }
        int j=0;
        for(; j<count.length; j++){
            if(count[j]>0) break;
        }
        return (char)('a'+j);
    }
}
//1, bit manipulate. zhongdian : initial char must be 0, not '0'!  (a^(a^b))==b! 
//zhongdian: 

class Solution {
    public char findTheDifference(String s, String t) {
        char in=0;
        for(int i=0; i<s.length(); i++) in=(char)(in ^ s.charAt(i));
        for(int i=0; i<t.length(); i++) in^=t.charAt(i);
        
        return in;
    }
}
//or
public char findTheDifference(String s, String t) {
	int n = t.length();
	char c = t.charAt(n - 1);
	for (int i = 0; i < n - 1; ++i) {
		c ^= s.charAt(i);
		c ^= t.charAt(i);
	}
	return c;
}
//or use int instead of char to go through bit manipulate 
public class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize variables to store sum of ASCII codes for 
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) charCodeS += (int)s.charAt(i);
        for (int i = 0; i < t.length(); ++i) charCodeT += (int)t.charAt(i);
        // Return the difference between 2 strings as char
        return (char)(charCodeT - charCodeS);
    }
}

UPDATE:
Thanks to @zzhai for providing this optimization! :) 
"1 optimization: As t.length() is just 1 character longer than s.length(), we can use 1 pass to process both strings (20% better runtime performance)."
public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }