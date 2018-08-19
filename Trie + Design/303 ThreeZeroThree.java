package Leetcode2;

public class ThreeZeroThree {

}
//1, HashMap to store all results of (0 - i) to data-structure

class NumArray {
    int[] arr;
    HashMap<Integer, Integer> resall;  // to store all results already calculated
    public NumArray(int[] nums) {
        this.arr = nums; 
        resall = new HashMap<Integer, Integer>();
        int res = 0 ;
        for(int i = 0; i <= arr.length; i++){
            resall.put(i, res);
            if(i < arr.length){
                res += arr[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        int res = 0; 
        if(i < 0) i = 0; 
        if(j >= arr.length) j = arr.length - 1; 
        
        return resall.get(j+1) - resall.get(i);
    }
}

//2, use array instead of HashMap

class NumArray {
    int[] arr;
    //arr[i] as the sum of nums[0] to nums[i - 1]; 
    public NumArray(int[] nums) {
        this.arr = new int[nums.length + 1]; 
        for(int i = 0; i < nums.length; i++){
            arr[i + 1] = nums[i] + arr[i];
        }
    }
    
    public int sumRange(int i, int j) {
        int res = 0; 
        if(i < 0) i = 0; 
        if(j >= arr.length) j = arr.length - 1; 
        return arr[j + 1] - arr[i];
    }
}