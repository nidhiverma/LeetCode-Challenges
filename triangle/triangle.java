class Solution {
    Integer[][] dp;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        dp = new Integer[triangle.size()][triangle.size()];
        return helper(triangle, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int i, int j) {
        if(i >= triangle.size()) {
            return 0;
        } 
        if(dp[i][j] != null) return dp[i][j];
        
        int a = helper(triangle, i+1, j);
        int b = helper(triangle, i+1, j+1);
        
        dp[i][j] = Math.min(a, b) + triangle.get(i).get(j);
        
        return dp[i][j];
    }
}