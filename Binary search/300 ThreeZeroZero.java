package Leetcode;

public class ThreeZeroZero {

}
//TreeMap, get all floorKey update when inserted. 


//tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
//For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
//
//len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
//len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
//len = 3   :      [4, 5, 6]            => tails[2] = 6
//We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}
//or updated with Arrays.binarySearch(int[], start, end, target) (O(logN))
ublic class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}