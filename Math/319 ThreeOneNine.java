package Leetcode2;

public class ThreeOneNine {

}
//1 1-d dp O(n^2) time, o(n) space; 

public int bulbSwitch(int n) {
      int res=0;
      //if(n==1) return 1;
      boolean[] bulbs=new boolean[n];
      for(int i=1; i<=n; i++){
          for(int j=0; j<n; j++){
              if((j+1)%i==0) bulbs[j]=!bulbs[j];
              if(i==n && bulbs[j]) res++;
          }
      }
      return res;
  }


//2, Math.sqrt, O(logN) time, o(1) space; 


public int bulbSwitch(int n) {
      int res=0;
      for(int i=1; i<=(int)Math.sqrt(n); i++){
          if(i*i<=n) res++;
          else break;
      }
      return res;
  }
//2-simplified, o(1) time

class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.floor(Math.sqrt(n));
    }
}
