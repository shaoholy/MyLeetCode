package Leetcode2;

public class FourZeroNine {

}
//O(N) time O(1) space, Character.isLowerCase(type name = new type();
public int longestPalindrome(String s) {
    int[] counts = new int[52];
    char[] c = s.toCharArray();
    for(char x: c){
        if(Character.isLowerCase(x)) counts[x-'a']++;
        else counts[x-'A'+26]++;
    }
    
    int res = s.length();
    boolean flag = true; // to omit only one odd letter to be in the middle
    for(int x : counts){
        if(x%2 == 1){
            if(flag) flag = false; 
            else res--; 
        }
    }
    return res; 
}