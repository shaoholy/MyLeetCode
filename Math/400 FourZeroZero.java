package Leetcode2;

public class FourZeroZero {

}
//zhongdian: int overflow(n/idx>k) timeO(log10(N))
public int findNthDigit(int n) {
    int k=9, idx=1;
    while(n/idx>k){
        n-=k*idx;   
        k*=10;
        idx++;
    }
    int num=n/idx, re=n%idx;
    if(re!=0) num++;
    int posi=num+(int)Math.pow(10,(idx-1))-1;
    String p=Integer.toString(posi);
    return Integer.parseInt(p.substring((re+idx-1)%idx,(re+idx-1)%idx+1));
}