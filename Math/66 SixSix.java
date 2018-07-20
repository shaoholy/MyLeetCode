package Leetcode2;

public class SixSix {

}
//iteration. zhongdian: use ArrayList, not LinkedList! Too Slow !
class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        int input=1;
        for(int i=digits.length-1; i>=0; i--){
            if(input==1 && digits[i]==9){
                res.add(0);
                if(i==0) res.add(1);
            }else{
                res.add(digits[i]+input);
                input=0;
            }
        }
        int[] resarray=new int[res.size()];
        for(int i=0; i<res.size(); i++) resarray[i]=res.get(res.size()-1-i);
        return resarray;
    }
}
//possible in-place solution
public int[] plusOne(int[] digits) {
    
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}