class Solution {
    public int maxProduct(int[] nums) {
        int prefix = nums[0];
        int suffix = nums[nums.length-1];
        
        int maxProd = Math.max(prefix, suffix);
        
        for(int i = 1; i < nums.length; i++) {
            if(prefix == 0) {
                prefix = nums[i];
            }
            else {
                prefix = prefix * nums[i];
            }
            maxProd = Math.max(maxProd, prefix);
        }
        
        for(int i = nums.length-2; i >= 0; i--) {
            if(suffix == 0) {
                suffix = nums[i];
            }
            else {
                suffix = suffix * nums[i];
            }
            maxProd = Math.max(maxProd, suffix);
        }
        
        return maxProd;
    }
    
}