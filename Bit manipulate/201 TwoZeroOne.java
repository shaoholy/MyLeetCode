package Leetcode;

public class TwoZeroOne {

}
//bit manipulation
//zhongdian: 如果前面位数不等，那么后面一定不等

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      int i = 0; // i means we have how many bits are 0 on the right
      while(m != n){  //zhongdian: 如果前面位数不等，那么后面一定不等
        m >>= 1;
        n >>= 1;
        i++;  
      }  
      return m << i;  
    }
}