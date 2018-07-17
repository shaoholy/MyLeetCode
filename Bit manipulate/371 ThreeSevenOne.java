package Leetcode;

public class ThreeSevenOne {

}

//bit mani
//记住： a+b=a^b + (a&b)<<1
class Solution {
    public int getSum(int a, int b) {
         return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
        } 
}
//Recursive
public int getSubtract(int a, int b) {
	return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
}

//Get negative number
public int negate(int x) {
	return ~x + 1;
}