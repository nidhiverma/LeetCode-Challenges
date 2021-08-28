class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        
        for(int i = 0; i < nums.length; i++) {
            lo = Math.max(nums[i], lo);
            hi += nums[i];
        }
        
        int maxSum = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isFeasible(nums, mid, m)) {
                maxSum = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return maxSum;
    }
    
    private boolean isFeasible(int[] nums, int maxSum, int m) {
        int splits = 1, sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(sum > maxSum) {
                splits++;
                sum = nums[i];
                
                if(splits > m) return false;
            }
        }
        return true;
    }
}