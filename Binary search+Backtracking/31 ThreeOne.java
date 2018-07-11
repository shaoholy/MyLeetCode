package Leetcode;

public class ThreeOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//1, find the rightest num which has smaller num to its right; 2, exchange the smallest larger num on its right with it; 3, swap every num from its right
class Solution {
public void nextPermutation(int[] nums) { 
    if(nums==null || nums.length==0 || nums.length==1) return;
    for(int k=nums.length-2; k>=0; k--){
        for(int i=k+1; i<nums.length; i++){
            if(nums[i]>nums[k]){
                int j=i+1;
                for(; j<nums.length; j++){
                    if(nums[j]<=nums[k]) break;
                }
                int temp=nums[k];
                nums[k]=nums[j-1];
                nums[j-1]=temp;
                int start=k+1, end=nums.length-1;
                while(start<end){
                    int temp2=nums[start];
                    nums[start++]=nums[end];
                    nums[end--]=temp2;
                }
                return;
            }
        }
    }
    int start=0, end=nums.length-1;
    while(start<end){
        int temp2=nums[start];
        nums[start++]=nums[end];
        nums[end--]=temp2;
    }
}
}