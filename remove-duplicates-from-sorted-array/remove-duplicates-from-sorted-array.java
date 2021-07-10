class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        
        while(j < nums.length) {
            nums[i] = nums[j];
            
            while(j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            i++;
        }
        return i;
    }
}