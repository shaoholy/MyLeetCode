package Leetcode2;

public class TwoZeroFour {

}
///1, iteration by 2 (or 1)
class Solution {
    public int countPrimes(int n) {
        int count=1; 
        if(n==2 || n==1 ||n==0) return 0;

        for(int i=3;i<n; i=i+2){
            if(checkp(i)) count++;
        }
        return count;
    }
    private boolean checkp(int n){
        for(int i=3; i<=(int)Math.pow(n, 0.5); i=i+2){
            if(n%i==0) return false;
        }
        return true;
    }
}

//use boolean[] to calculate 
class Solution {
    public int countPrimes(int n) {
        int count=0; 
        if(n==2 || n==1 ||n==0) return 0;
        boolean[] isprime=new boolean[n];

        for(int i=2;i<n; i++){
            if(!isprime[i]) {
            		count++;
            		for(int j=2; j*i<n; j++)
            			isprime[i*j]=true;
            }
            
        }
        return count;
    }
}
///simplified. boolean[] record only odd positions, faster
class Solution {
public int countPrimes(int n) {
	if( n <=2) {
		return 0;
	}
	int c= 1;
	boolean isNotPrime[] = new boolean[n+1];
	for(int i=3;i*i<=n;i=i+2) {
		if(isNotPrime[i]) {
			continue;
		}
		for(int j= i*i ;j<=n;j=j+2*i) {
			isNotPrime[j] = true;
		} 
	}
	for(int i =3;i<n;i=i+2){
		if(!isNotPrime[i]) {
			c++;
		}
	}
	return c;
}
}
