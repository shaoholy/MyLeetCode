package Leetcode2;

public class TwoZeroTwo {

}
///1, hashset to catch loop

public boolean isHappy(int n) {
      HashSet<Integer> vis=new HashSet<Integer>();
      vis.add(n);
      while(n!=1){
          int nextint=0;
          while(n!=0){
              nextint+=(n%10)*(n%10);
              n/=10;
          }
          if(vis.contains(nextint)) return false;
          else vis.add(nextint);
          n=nextint;
      }
      return true;
  }
//2, linkedlist slow + fast

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }while(slow != fast);
        if(slow == fast && slow == 1) return true;
        return false;
    }
    private int squareSum(int n){
        int res = 0;
        while(n > 0){
            int digit = n % 10;
            res += digit*digit;
            n /= 10;
        }
        return res;
    }
}
