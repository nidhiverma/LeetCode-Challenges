/*
    @author: Nidhi
    
    Approach 1: Use HashSet
        Add all the [0...n] in a set
        traverse given nums array, remove current num value from set
        in the end, we'll be left with only 1 value in the set, this is our missing value
        
        Time Complexity: O(n)
        Space Complexity: O(n)
   
    Approach 2: Take xor of [0..n] with nums[] values
        All the duplicate values will be cancelled out
        the final xor value is the missing value
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        
    Approach 3: 
        sort the array
        apply binary search
        if midIndex == nums[midIndex], missing element lies on the right of mid element
        else missing element lies on its left
        
        Time Complexity: O(nlogn)
        Space Complexity: O(1)
    
    Approach 4: 
        calculate N = natural sum of first n numbers
        missing value = N - sum(nums array)
        
        Time Complexity: O(n)
        Space Complexity: O(1)
*/

class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        
        // take xor of first n natural nos.
        for(int i = 1; i < nums.length+1; i++) {
            xor ^= i;
        }
        
        
        // take previous xor value and again apply xor to the given list of nums
        // in the end we'll be left with the value which is missing
        for(int num : nums) {
            xor ^= num;
        }
        
        return xor;
    }
}