package Leetcode2;

public class OneSixSix {

}
//166 Fraction to Recurring Decimal
//zhongdian: 1, use long to convert, avoid int overflow
//2, use num%den *10 as the loop input, use hashmap to check where the repeating starts. then StringBuilder.insert(int, char). 
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res=new StringBuilder();
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        res.append(((numerator >0) ^ (denominator > 0))&&(numerator!=0)? '-':"");
        long fir=num/den;
        res.append(fir);
        num%=den;
        if(num==0) return res.toString();
        else{
            res.append('.');
            HashMap<Long, Integer> map=new HashMap<Long, Integer>();
            map.put(num, res.length());
            while(num!=0){
                num*=10;
                res.append(num/den);
                num%=den;
                if(map.containsKey(num)){
                    int idx=map.get(num);
                    res.insert(idx, '(');
                    res.append(')');
                    break;
                }else{
                    map.put(num, res.length());
                }
            }
            return new String(res);
        }
    }
}