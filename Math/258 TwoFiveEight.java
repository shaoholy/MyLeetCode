package Leetcode2;

public class TwoFiveEight {

}
//1,
class Solution {
    public int addDigits(int num) {
        while(num/10!=0){
            num=getadd(num);
        }
        return num;
    }
    private int getadd(int num){
        int res=0;
        while(num!=0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}

//2, Congruence_formula
class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}