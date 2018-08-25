package Leetcode2;

public class FourEightZero {

}

//Two TreeSet, balanced, time O(n*logK)
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
	    if (n <= 0) return new double[0];
        double[] res = new double[n];
        TreeSet<Integer> left = getSet(nums);
        TreeSet<Integer> right = getSet(nums);
        for(int i = 0; i < nums.length; i++){
            if(left.size() >= right.size()){
                left.add(i);
                right.add(left.pollLast());
            }else{
                right.add(i);
                left.add(right.pollFirst());
            }
            
            
            if(left.size() + right.size() == k){
                res[i - k + 1] = left.size() == right.size()? 
                    nums[left.last()] / 2.0 + nums[right.first()] / 2.0 : nums[right.first()] / 1.0;
                //System.out.println(res[i - k + 1]);
                if(!left.remove(i - k + 1)){
                    right.remove(i - k + 1);
                }
            }
        }
        return res;
    }
    private static TreeSet<Integer> getSet(int[] nums){
        return new TreeSet<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return nums[a] == nums[b] ? a - b : nums[a] < nums[b] ? -1 : 1;
            }
        });
    }
}