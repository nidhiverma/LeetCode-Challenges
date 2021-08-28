class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int lo = 0, hi = 0;
        int min = nums[0], max = nums[0];
        
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        hi = max - min;
        
        int minDiff = 0;
        
        while(lo  <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isFeasible(nums, mid, k)) {
                minDiff = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return minDiff;
    }
    
    private boolean isFeasible(int[] nums, int diff, int k) {
        int count = 0, i = 0, j = 0;
        
        while(i < nums.length || j < nums.length) {
            while(j < nums.length && nums[j] - nums[i] <= diff) {
                j++;
            }
            count += j-i-1;
            i++;
        }
        return count >= k;
    }
} 