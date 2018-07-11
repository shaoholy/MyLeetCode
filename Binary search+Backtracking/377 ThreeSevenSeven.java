package Leetcode;

import java.math.BigInteger;

public class ThreeSevenSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

//not ok solution, long limit overflow
class Solution {
    int res;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        res=0;
        bt377(target, nums,0,new ArrayList<Integer>());
        return res;
    }
    private void bt377(int left, int[] nums, int start, ArrayList<Integer> cur){
        if(left==0){
            long overall=getNjie(cur.size()), tosub=1;
            System.out.println(overall);
            int pre=-1,count=1;
            for(int x: cur){
                if(x!=pre){
                    tosub=tosub*getNjie(count);
                    count=1;
                }else{
                    count++;}
                pre=x;
            }
            tosub*=getNjie(count);
            res+=(overall/tosub); 
}else{
        for(int i=start; i<nums.length; i++){
            if(nums[i]>left) break;
            cur.add(nums[i]);
            bt377(left-nums[i], nums, i, cur);
            cur.remove(cur.size()-1);
        }
        }
    }
    private long getNjie(int n){
        long r=1;
        for(long i=n; i>1; i--) r*=i;
        return (long)r;
    }

}
//dp
class Solution {
    public int combinationSum4(int[] nums, int target) {
       int[] dp= new int[target+1];
        dp[0]=1;
        for(int i=1; i<=target; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[j]<=i) dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}