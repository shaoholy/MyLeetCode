package Leetcode;

public class ThreeThreeFive {

}

//Categorize the self-crossing scenarios, there are 3 of them: 
// 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
// 2. Fifth line meets first line and works for the lines after
// 3. Sixth line crosses first line and works for the lines after

class Solution {
    public boolean isSelfCrossing(int[] x) {
        int len=x.length; 
        if(len<=3) return false;
        
        for(int i=3; i<len; i++){
            if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) return true;
            if(i>3)
                if(x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]) return true;
            if(i>4)
                if(x[i]+x[i-4]>=x[i-2] && x[i-2]>=x[i-4] && x[i-1]<=x[i-3]&& x[i-1]+x[i-5]>=x[i-3]) return true;
        }
        return false;
    }
}