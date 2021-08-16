class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n-2, j = n-1;
        
        // find the first non decreasing number from the end
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if(i >= 0) {
            // find the smallest number just greater than ith number from the end
            while(j > i && nums[j] <= nums[i]) j--;
            
            // swap ith and jth nums
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        // reverse the right half to get as least next permutation as possible
        j = n-1;
        i = i+1;
        
        while(i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
        
    }
}