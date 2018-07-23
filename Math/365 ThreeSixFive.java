package Leetcode2;

public class ThreeSixFive {

}
//GCD
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false; 
        if(z==x || z==y || z==x+y) return true; 
        
        return z%GCD(x, y)==0; 
    }
    private int GCD(int a, int b){
        if(b==0) return a;
        else return GCD(b, a%b);
    }
}
