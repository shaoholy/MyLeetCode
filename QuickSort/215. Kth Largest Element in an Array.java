class Solution {
    Random rd = new Random(); 
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivotIdx = rd.nextInt(end - start + 1) + start;
        swap(nums, start, pivotIdx);
        int left = start, right = end; 
        //this algorithm keeps: 1, even split of to left and right; 2, left ends up right of left
        while (left <= right) {
            while (left <= right && nums[left] > nums[start]) {
                left++;
            }
            while (left <= right && nums[right] < nums[start]) {
                right--; 
            }
            if (left <= right) { // must be <= to keep left < right
                swap(nums, left, right); 
                left++;
                right--;
            }
        }
        
        if (right - start + 1 >= k) {
            return quickSelect(nums, start, right, k); 
        } 
        if (left - start + 1 <= k) {
            return quickSelect(nums, left, end, k - left + start); 
        }
        return nums[right + 1];
        
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a]; 
        nums[a] = nums[b]; 
        nums[b] = tmp; 
    }
}