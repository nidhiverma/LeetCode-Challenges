class Solution {
    public int numTrees(int n) {
        int[][] memo = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return countWays(1, n, memo);
    }
    
    private int countWays(int l, int r, int[][] memo) {
        if(l >= r) return 1; // null tree
        
        if(memo[l][r] != -1) return memo[l][r];
        
        int totalWays = 0;
        for(int i = l; i <= r; i++) {
            int left = countWays(l, i-1, memo);
            int right = countWays(i+1, r, memo);
            
            totalWays += left * right;
        }
        
        return memo[l][r] = totalWays;
    }
}