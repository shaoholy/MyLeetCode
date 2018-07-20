package Leetcode2;

public class SixSeven {

}
//1, iteration
class Solution {
    public String addBinary(String a, String b) {
        char next='0'; 
        StringBuilder res=new StringBuilder();
        for(int i=Math.max(b.length(),a.length())-1;i>=0; i--){
            int idxa= a.length()>b.length()? i:i-(b.length()-a.length());
            int idxb= b.length()>a.length()? i:i-(a.length()-b.length());
            char achar= idxa>=0? a.charAt(idxa):'0';
            char bchar= idxb>=0? b.charAt(idxb):'0';
            if(achar=='0' && bchar=='0'){
                res.append(next);
                next='0';
            }else if(achar=='1' && bchar=='1'){
                res.append(next);
                next='1';
            }else{
                if(next=='1'){
                    res.append('0');
                }else{
                    res.append('1');
                }
            }
        }
        if(next=='1') res.append(next);
        return new String(res.reverse());
    }
}
//2 simplified
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}