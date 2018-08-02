package Leetcode2;

public class ThreeNineSix {

}
//1, brutal force, brutal iteration, o(N^2) time, o(1) space

public int maxRotateFunction(int[] A) {
    if(A==null || A.length==0 || A.length==1) return 0;
    int sum=0, max=Integer.MIN_VALUE;
    for(int i=0; i<A.length; i++)
        sum+=i*A[i];
    max=Math.max(max, sum);
    int posi=A.length-1;
    for(int i=1; i<A.length; i++){
        for(int j=0; j<A.length; j++){
        if(j==posi)
            sum-=(A.length-1)*A[j];
        else sum+=A[j];
        }
        max=Math.max(max, sum);
        posi--;
    }
    return max;
}
//2, simplified from 1, o(N) time
public int maxRotateFunction(int[] A) {
    if(A==null || A.length==0 || A.length==1) return 0;
    int sum=0, max=Integer.MIN_VALUE, roundsum=0;
    for(int i=0; i<A.length; i++){
        roundsum+=A[i];
        sum+=i*A[i];
    }
    max=Math.max(max, sum);
    int posi=A.length-1;
    for(int i=posi; i>0; i--){
        sum+=roundsum;
        sum-=(A.length)*A[i];
        max=Math.max(max, sum);
    }
    return max;
}