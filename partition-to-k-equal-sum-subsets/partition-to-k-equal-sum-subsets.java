class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int num: nums) totalSum += num;
        
        if(totalSum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        
        return helper(nums, 0, 0, totalSum/k, k, visited);
    }
    
    private boolean helper(int[] nums, int idx, int currSum, int partitionSum, int k, boolean[] visited) {
        if(k == 1) return true;
        
        if(currSum == partitionSum) {
            return helper(nums, 0, 0, partitionSum, k-1, visited);
        }
        
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i] && nums[i] + currSum <= partitionSum) {
                visited[i] = true;
                if(helper(nums, idx+1, nums[i]+currSum, partitionSum, k, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}