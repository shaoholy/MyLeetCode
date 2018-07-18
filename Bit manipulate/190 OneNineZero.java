package Leetcode;

public class OneNineZero {

}
//1, two points iteration 2, Integer.reverse(public class Solution {
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left=31, right=0, res=0;
        while(left>right){
            res|=((n>>right)&1)<<left;
            res|=((n>>left)&1)<<right;
            left--;
            right++;
        }
        return res;
        // return Integer.reverse(n);
    }
}