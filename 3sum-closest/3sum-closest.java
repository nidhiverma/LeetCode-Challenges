/*
    @author: Nidhi
    
    Approach1: 
        Use Two Pointers
        
        Time Complexity: O(n^2)
        Space Complexity: O(1)
        
            
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if(Math.abs(sum-target) <  minDiff) {
                    minDiff = Math.abs(sum-target);
                    ans = sum;
                }
                
                if(sum < target) j++;
                else k--;
            }
        }
        return ans;
    }
}