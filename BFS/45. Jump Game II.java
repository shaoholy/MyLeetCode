    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1) return 0;
        int i = 0, curMax = 0, level = 0; 
        while (i <= curMax) {
            int furthest = curMax; 
            for ( ; i <= curMax; i++) {
                furthest = Math.max(furthest, i + nums[i]); 
                if (furthest >= nums.length - 1) {
                    return level + 1; 
                }
            }
            level++;
            curMax = furthest; 
        }
        return -1; 
    }