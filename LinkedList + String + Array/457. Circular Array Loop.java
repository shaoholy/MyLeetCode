class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = advance(i, nums); 
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[advance(fast, nums)] > 0) {
                if (slow == fast) {
                    if (slow == advance(slow, nums)) {
                        break;
                    }
                    return true; 
                }
                slow = advance(slow, nums); 
                fast = advance(advance(fast, nums), nums); 
            }
            
            //loop not found, set all in path to 0
            slow = i; 
            int val = nums[slow];
            while (val * nums[slow] > 0) {
                int next = advance(slow, nums); 
                nums[slow] = 0; 
                slow = advance(slow, nums); 
            }
        }
        return false; 
    }
    
    private int advance(int i, int[] nums) {
        int nextint = i + nums[i]; 
        return nextint >= 0 ? nextint % nums.length : nums.length + nextint % nums.length;
    }
}