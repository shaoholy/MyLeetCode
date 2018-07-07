package Leetcode;

public class ThreeSevenFour {

}
//binary search time O(logN)
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int mid=1+(n-1)/2, start=1, end=n;
        while(guess(mid)!=0){
            if(guess(mid)==1) start=mid+1;
               else end=mid-1;
                mid=start+(end-start)/2;
        }
        return mid;
        
    }
}