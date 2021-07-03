class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        
        if(sum % 2 != 0) return false;
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        sum /= 2;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
    
/*
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        
        if(sum % 2 != 0) return false;
        
        Arrays.sort(nums);
        memo = new Boolean[nums.length+1][sum+1];
        
        boolean[] visited = new boolean[nums.length];
        return helper(nums, 0, 0, sum/2, visited);
    }
    
    private boolean helper(int[] nums, int idx, int sum, int targetSum, boolean[] visited) {
        if(targetSum == sum) return true;
        if(memo[idx][sum] != null) return memo[idx][sum];
        
        for(int i = idx; i < nums.length; i++) {
            if(sum + nums[i] > targetSum) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
            visited[i] = true;
            if(helper(nums, i+1, sum+nums[i], targetSum, visited)) {
                memo[idx][sum] = true;
                return true;
            }
            visited[i] = false;
        }
        memo[idx][sum] = false;
        return false;
    }
*/
}