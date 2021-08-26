class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, len = 0;
        
        while(j < nums.length) {
            if(nums[j] == 1) j++;
            else if(nums[j] == 0) {
                if(k == 0) {
                    len = Math.max(len, j-i);
                    while(nums[i] == 1) i++;
                    i++;
                }
                else {
                    k--;
                }
                j++;
            }
        }
        
        len = Math.max(len, j-i);
        return len;
    }
}