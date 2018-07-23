package Leetcode2;

public class ThreeNineSeven {

}
//Binary. zhongdian, int overflow. 
class Solution {
    public int integerReplacement(int n) {
        int count=0;
        while(n!=1){
            if(n%2==0){
                count++;
                n/=2;
            }else{
                if(n==Integer.MAX_VALUE) {
                    n=(n/2+1);
                    count++;}
                else if((n-1)%4==2 && n!=3) n+=1;
                else n-=1;
                count++;
            }
        }
        return count;
    }
}

//2, bit manipulation. zhongdian: rightMostBit(n)

class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n == 0 || n == 2) return 1;
        if (n == 3) return 2;
        if (n == 2147483647) return 2 + integerReplacement(1073741824);
        if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        int up = rightMostBit(n+1);
        int dn = rightMostBit(n-1);
        if (up > dn) return 1 + integerReplacement(n + 1);
        return 1 + integerReplacement(n - 1);
    }
    public int rightMostBit(int n){
        for (int i=1; i<32; i++){
            if ((1<<i & n) != 0) return i;
        }
        return -1;
    }
}