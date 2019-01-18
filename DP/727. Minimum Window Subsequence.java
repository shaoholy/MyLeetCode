public String minWindow(String S, String T) {
        //dp[i][j] means: for S(0~i) & T(0~j), the "largest" starting index in S which matches T
        //so 1, start point : dp[0][0] == 0 : -1;  
        //2, dp[i][0] = charAt(i) == charAt(j) ? i : dp[i - 1][0];
        //3, dp[i][j] = charAt(i) == charAt(j) ? dp[i - 1][j - 1] : dp[i][j - 1]; 
        int[][] dp = new int[S.length()][T.length()];
        for (int[] arr: dp) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -1;
            }
        }
        
        //set the j == 0
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                dp[i][0] =  S.charAt(i) == T.charAt(0) ? 0 : -1;
            } else {
                dp[i][0] = S.charAt(i) == T.charAt(0) ? i : dp[i - 1][0];
            }
        }
        //set j > 0
        for (int i = 1; i < S.length(); i++) {
            for (int j = 1; j < T.length(); j++) {
                dp[i][j] = S.charAt(i) == T.charAt(j) ? dp[i - 1][j - 1] : dp[i - 1][j]; 
            }
        }
        //go through j == T.length() - 1 row to see the shortest 
        int len = Integer.MAX_VALUE; 
        String res = "";
        for (int i = S.length() - 1; i >= 0; i--) {
            if (dp[i][T.length() -1] == -1) {
                continue;
            } else {
                if ((i - dp[i][T.length() -1] + 1) <= len ) {
                    len = i - dp[i][T.length() -1] + 1;
                    res = S.substring(dp[i][T.length() - 1], i + 1);
                }
            }
        }
        System.out.println(len);
        return len == Integer.MAX_VALUE ? "" : res; 
    }