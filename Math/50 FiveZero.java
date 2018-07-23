package Leetcode2;

public class FiveZero {

}
//recur skill: -int overflow: 1/x * myPow(1/x, -(n+1));
class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1.0) return 1.0;
        if(n<0)
            return 1/x * myPow(1/x, -(n+1));
        else{
                if(n%2==1)
                    return myPow(x*x, n/2)*x;
                else 
                    return myPow(x*x, n/2);
        }
    }
}