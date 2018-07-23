package Leetcode2;

public class ThreeSixSeven {

}
//1, Math.sqrt
class Solution {
    public boolean isPerfectSquare(int num) {
        return Math.sqrt(num)-(int)Math.sqrt(num)>0? false:true;
    }
}

//binary search. time O(log(num)). zhongdian: be aware of int & double opt. 
class Solution {
    public boolean isPerfectSquare(int num) {
        int bottom=1, top=num, mid=1;
        if(num==1) return true;
        while(bottom<=top){
            mid=bottom+(top-bottom)/2;
            if(mid>num/mid){
                top=mid-1;
            }else {
                if((mid+1)>num/(mid+1))
                    break;
                bottom=mid+1;
            }
        }
        return mid*mid==num;
    }
}