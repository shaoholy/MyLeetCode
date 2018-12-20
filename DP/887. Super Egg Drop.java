public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1]; //dp[N][k] as the max floor to check with K eggs and N moves
        //principle: dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1 (关键！)
        //binary check and plus current floor. 
        
        int m = 0; 
        while (dp[m][K] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1; 
            }
        }
        return m;
    }