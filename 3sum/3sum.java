/*
    @author: Nidhi
    
    Brute Force Approach:
        Consider every triplet in the array
        check for valid triplet, if valid add it to the result list
        
        Time Complexity: O(n^3)
        Space Complexity: O(1)
        
    Efficient Approach:
        Sort the array.
        For every num i, check for every valid pair with sum = - num[i] using efficient 2Sum approach
        Time Complexity: O(n^2)
        Space Complexity: O(1)

*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++) {
            // avoid considering duplicate triplets
            if(i == 0 || i > 0 && nums[i] != nums[i-1]) {
                twoSum(nums, i+1, nums.length-1, -1*nums[i], result);
            }
        }
        return result;
    }
    
    private void twoSum(int[] nums, int i, int j, int targetSum, List<List<Integer>> result) {
        while(i < j) {
            
            int sum = nums[i] + nums[j];

            if(sum == targetSum) {
                result.add(new ArrayList(Arrays.asList(-targetSum, nums[i++], nums[j])));
                while(i < j && nums[i] == nums[i-1]) i++; 
            }
            else if(sum < targetSum) {
                i++;
            }
            else {
                j--;
            }
        }
        return;
    }
}