/*
    @author: Nidhi
    
    Time Complexity: O(log n)
    Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            
            if(nums[hi] < nums[mid]) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}