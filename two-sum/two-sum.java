/*
    @author: Nidhi Verma
    Approach1: 
        For every element check for its compliment in the rest of the array
        Time Complexity: O(n^2)
        Space Complexity: O(1)
    
    Approach2: 
        Maintain a hashmap(element, index). Insert current element in the hashmap if its compliment is not already
        present in the set, otherwise we have found our answer.
        
        Time Complexity: O(n)
        Space Complexity: O(n)
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        
        for(int i = 1; i < nums.length;  i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}