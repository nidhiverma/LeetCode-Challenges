class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostKDistinct(nums, k) - atmostKDistinct(nums, k-1);
    }
    
    private int atmostKDistinct(int[] nums, int k) {
        int[] count = new int[nums.length+1];
        int i = 0, j = 0, counter = 0, ans = 0;
        
        while(j < nums.length) {
            if(count[nums[j]]++ == 0) counter++;
            
            while(counter > k) {
                int idx = nums[i++];
                if(--count[idx] == 0) counter--;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
} 