class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length < 2) return;
        
        int i = 0, j = 0;
        
        while(j < nums.length) {
            if(nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            else if(nums[i] != 0) i++;
            j++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[j];
        nums[j] = 0;
    }
}