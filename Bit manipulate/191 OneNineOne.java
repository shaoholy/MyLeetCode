package Leetcode;

public class OneNineOne {

}
//1, Integer.bitCount()
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
//2, iteration count
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0; i<=31; i++){
            if(((n>>i)&1)==1) count++;
        }
        return count;
    }
}