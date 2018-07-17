package Leetcode;

public class TwoSixEight {

}
//bit manipu
class Solution {
    public int missingNumber(int[] nums) {
        int ini=0;
        for(int i=1; i<=nums.length; i++) ini^=i;
        for(int i=0; i< nums.length; i++) ini^=nums[i];
        return ini;
    }
}
//more concise one
public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;
}