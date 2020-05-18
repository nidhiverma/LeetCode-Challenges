class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        int i = 1;
        while(i < nums.length) {
            res ^= nums[i];
            i++;
        }
        return res;
    }
}
