package Leetcode;

public class ThreeThreeOne {

}
//backward iteration, o(n) time. using null number and num number to compare. 1, null>num; 2, final null-final num==1
class Solution {
    public boolean isValidSerialization(String preorder) {
        int numcount=0, nullcount=0;
        for(int i=preorder.length()-1; i>=0; i--){
            if(preorder.charAt(i)==',') continue;
            if(preorder.charAt(i)=='#') {
                nullcount++;
                continue;
            }
            if(preorder.charAt(i)-'0'>=0 && '9'-preorder.charAt(i)>=0){
                numcount++;
                while(i-1>=0 && preorder.charAt(i-1)!=',') i--;
                if(nullcount-numcount<1 ) return false;
            }
        }
        return nullcount-numcount==1;
    }
}