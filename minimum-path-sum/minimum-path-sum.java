class Solution {
    int minPath = Integer.MAX_VALUE;
    
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(grid, 0, 0, memo);
    }
    
    private int helper(int[][] grid, int i, int j, int[][] memo) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        
        if(memo[i][j] != -1) return memo[i][j];
        
        if(i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }
        
        return memo[i][j] = Math.min(helper(grid, i+1, j, memo), helper(grid, i, j+1, memo)) + grid[i][j];
    }
}