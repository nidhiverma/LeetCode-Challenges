class Solution {
    int[][][] memo;
    int mod = (int)(1e9 + 7);
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][51];
        
        for(int[][] r : memo) {
            for(int[] c: r) {
                Arrays.fill(c, -1);
            }
        }
        return helper(m,n,maxMove, startRow, startColumn);
    }
    public int helper(int m, int n, int N, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        
        if(memo[i][j][N] != -1) return memo[i][j][N];
        
        memo[i][j][N] = (((helper(m, n, N - 1, i - 1, j) % mod
            + helper(m, n, N - 1, i + 1, j) % mod) % mod
            + helper(m, n, N - 1, i, j - 1) % mod) % mod
            + helper(m, n, N - 1, i, j + 1) % mod) % mod;
        return memo[i][j][N];
    }
}