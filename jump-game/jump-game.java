/*
    @author: Nidhi
    
    Approach: Greedy
        
        traverse the whole nums array
        at every index i, calculate the max jump distance from this index
        compare the max jump_distance at index i with farthest jump distance so far 
        and update it accordingly
        
        if max jump distance so far exceeds last index, return true
        else return false
        
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        int farthestJump = 0;
        
        for(int i = 0; i < nums.length-1; i++) {
            farthestJump = Math.max(farthestJump, nums[i] + i);
            
            if(nums[i] == 0 && farthestJump == i) return false;
            
            if(farthestJump >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
} 