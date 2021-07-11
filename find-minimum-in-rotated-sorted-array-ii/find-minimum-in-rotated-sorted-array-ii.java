/*
    @author: Nidhi
    
    Approach: Binary Search
    left = 0
    right = nums.length - 1
    
    mid = (left + right)/2
    if mid < right: search in [left, mid]       O(log n)
    if mid > right: search in [mid+1, right]    O(log n)
    if mid == right: search in [left, right-1]  O(n)
        case 1: left --- mid --- right O(n)
        
        case 2:      --- mid --- right
                    /
                left 
                
        case 3: left --- mid  --- right
                             /
                            /
                            
        case 4: left ---  -- mid --- right
                         /
                        /
    
    Time Complexity: O(n)
    Space Complexity: O(1)

*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]) right = mid;
            else if(nums[mid] > nums[right]) left = mid+1;
            else right--;
        }
        return nums[left];
    }
}