//1, max space

public int backPack(int[] A, int m) {
	//dp[i][j] : with j space, how much space can be occupied from 0 - i object

    int[][] dp = new int[A.length][m + 1];
    for (int j = 1; j < m + 1; j++) {
        if (j >= A[0]) {
            dp[0][j] = A[0];
        } else {
            dp[0][j] = 0;
        }
        for (int i = 1; i < A.length; i++) {
            if (j < A[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]); ///key line
            }
        }
    }
    return dp[A.length - 1][m];
}

// to o(n) space optimize
public int backPack(int[] A, int m) {
    int[] dp = new int[m + 1];
    for (int i = 0; i < A.length; i++) {
        for (int j = m; j > 0; j--) {
            if (j >= A[i]) {
                dp[j] = Math.max(dp[j - A[i]] + A[i], dp[j - 1]);
            }
        }
    }
    return dp[m];
}

//2, max value
public int backPack_MaxValue(int[] A, int[] V, int m) {
	//dp[i][j] : with j space, max value can be occupied from 0 - i object
    int[][] dp = new int[A.length][m + 1];
    for (int j = 1; j < m + 1; j++) {
        if (j >= A[0]) {
            dp[0][j] = V[0];
        } else {
            dp[0][j] = 0;
        }
        for (int i = 1; i < A.length; i++) {
            if (j < A[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j - A[i]] + V[i], dp[i - 1][j]); ///key line
            }
        }
    }
    return dp[A.length - 1][m];
}

//O(n) space op
public int backPack(int[] A, int[] V, int m) {
	  int[] dp = new int[m + 1];
	  for (int i = 0; i < A.length; i++) {
	      for (int j = m; j > 0; j--) {
	          if (j >= A[i]) {
	              dp[j] = Math.max(dp[j - A[i]] + V[i], dp[j - 1]);
	          }
	      }
	  }
	  return dp[m];
}


//3, max value with duplicate choice

public int backPack_MaxValue(int[] A, int[] V, int m) {
	//dp[i][j] : with j space, max value can be occupied from 0 - i object
    int[][] dp = new int[A.length][m + 1];
    for (int j = 1; j < m + 1; j++) {
        if (j >= A[0]) {
            dp[0][j] = V[0] * (j / A[0]);
        } else {
            dp[0][j] = 0;
        }
        for (int i = 1; i < A.length; i++) {
        	int times = j / A[i];
        	int max = dp[i - 1][j];
        	for (int k = 1; k <= times; k++) {
        		max = Math.max(max, dp[i - 1][j - A[i] * k] + k * V[i]);
        	}
            dp[i][j] = max;
        }
    }
    return dp[A.length - 1][m];
}

//simplified

public int backPackIII(int m, int[] A, int[] V) {
    int[] dp = new int[m + 1];
    for (int i = 0; i < A.length; i++) {
        for (int j = 1; j <= m; j++) {
            if (j >= A[i]) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
    }
    return dp[m];
}


//4, find the number of possible combinations that add up to a positive integer target.

public int backPackVI(int[] nums, int target) {
   int[] dp = new int[target + 1];
   dp[0] = 1;
   for (int j = 1; j <= target; j++) {
       for (int i = 0; i < nums.length; i++) {
           if (j >= nums[i]) {
               dp[j] += dp[j - nums[i]];
           }
       }
   }
   return dp[target];
}

//5,  Given n items with size nums[i] which an integer array and all positive numbers.
 //An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 //Each item may only be used once
public int backPackVI(int[] nums, int target) {
	int[] dp = new int[target+1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
        for (int j = target; j >= 0; j--) {
            if (j >= nums[i]) dp[j] += dp[j-nums[i]];
        }
    }
    return dp[target];
}
