package Leetcode2;

public class ThreeSevenTwo {

}

//ab % k = (a%k)(b%k)%k=(a)(b%k)%k
class Solution {
    public int superPow(int a, int[] b) {
        if(a%1337==0) return 0;
        return superPow(a, b, b.length-1, 1337);
        
    }
    
    private int superPow(int x,int[] b, int posi, int k){
        if(posi==0)
            return pow(x, b[0], k);
        
        return pow(superPow(x, b, posi-1, k), 10, k)*pow(x, b[posi], k)%k;
    }
    private int pow(int x, int y, int k){
        x%=k;
        int pow=1;
        for(int i=0; i<y; i++){
            pow=(pow*x)%k;
        }
        return pow;
    }
}
