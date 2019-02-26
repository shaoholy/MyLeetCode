class Solution {
    public boolean canCross(int[] stones) {
        boolean[] dp = new boolean[stones.length];
        Map<Integer, List<Integer>> stoneToSteps = new HashMap<>();
        dp[0] = true; 
        if (stones[1] != stones[0] + 1) {
            return false; 
        }
        dp[1] = true;
        stoneToSteps.put(1, new ArrayList<>());
        stoneToSteps.get(1).add(1);
        for (int i = 2; i < stones.length; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (!dp[j]) {
                    continue;
                }
                List<Integer> steps = stoneToSteps.get(j);
                int gap = stones[i] - stones[j];
                for (int step : steps) {
                    if (gap == step || gap == step + 1 || gap == step - 1) {
                        dp[i] = true;
                        stoneToSteps.putIfAbsent(i, new ArrayList<>());
                        stoneToSteps.get(i).add(gap);
                        break;
                    }
                }
            }
        }
        return dp[stones.length - 1];
    }
}