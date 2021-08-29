class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        
        // initialize 0th row
        Arrays.fill(dp[0], Integer.MAX_VALUE-1);
        
        
        // initialize 0th col
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        // initialize 1st row
        for(int j = 1; j <= amount; j++) {
            
            // if coin value evenly divides the amount
            if(j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            }
            // else ignore this coin, put INT_MAX
            else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }
        
        // fill rest of the values
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1, dp[i-1][j]); 
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount] < Integer.MAX_VALUE-1 ? dp[n][amount] : -1;
    }
}