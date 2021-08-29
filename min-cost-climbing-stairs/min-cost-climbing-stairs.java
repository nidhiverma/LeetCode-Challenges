class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo));
    }
    
    private int helper(int[] cost, int i, int[] memo) {
        if(i >= cost.length) return 0;
        if(memo[i] != -1) return memo[i];
        
        return memo[i] = Math.min(helper(cost, i+1, memo), helper(cost, i+2, memo)) + cost[i];
    }
} 