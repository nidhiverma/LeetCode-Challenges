class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        
        for (int num : nums) {
            int i = binarySearch(dp, num, 0, len);
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    
    private int binarySearch(int[] nums, int val, int lo, int hi){
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            
            if(nums[mid] == val) return mid;
            if(nums[mid] < val) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}