/*
    @author: Nidhi 
    
    Brute Force Approach: Recursive
    Time Complexity: O(f^d)  --> (not sure, please confirm)
    Space Complexity: O(d)
    
    Optimized: DP
    Time Complexity: O(d*f*target)
    Space Complexity: O(d*target)
    
    
*/
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d+1][target+1];
        int mod = (int) (1e9 + 7);
        
        // target = 0 and die = 0
        dp[0][0] = 1;
        
        // if there's only 1 dice, then target only in range[1..min(f, target)] is possible
        for(int i = 1; i <= Math.min(f, target); i++) {
            dp[1][i] = 1;
        }
        
        for(int i = 2; i <= d; i++) {
            for(int j = 1; j <= target; j++) {
                long sum = 0;
                for(int k = 1; k <= f && j >= k; k++) {
                    sum = (sum + dp[i-1][j-k]) % mod;
                }
                dp[i][j] = (int)sum;
            }
        }
        
        return dp[d][target];
    }
    
// Memoization
//     int[][] memo;
//     int mod = (int) (1e9 + 7);
    
//     private int numRollsHelper(int d, int f, int target) {
//         if(d == 0) {
//             if(target == 0) return 1;
//             return 0;
//         }
        
//         if(memo[d][target] != -1) return memo[d][target];
        
//         long sum = 0;
        
//         for(int i = 1; i <= f; i++) {
//             if(target >= i)
//                 sum = (sum + numRollsToTarget(d-1, f, target-i)) % mod;
//             else 
//                 break;
//         }
//         memo[d][target] = (int) sum;
//         return (int)sum;
//     }
}