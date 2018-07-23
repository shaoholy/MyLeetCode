package Leetcode2;

public class SixNine {

}

//1, binary search
class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int start=1, top=x, bottom=1; 
        while(!(x/start==start || start<x/start&&(start+1)>x/(start+1))){
            start=bottom+(top-bottom)/2;
            if(start>x/start){
                top=start-1;
            }else if(start<x/start){
                bottom=start+1;
            }
        }
        return start;
    }
}
//or, hehe

class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}