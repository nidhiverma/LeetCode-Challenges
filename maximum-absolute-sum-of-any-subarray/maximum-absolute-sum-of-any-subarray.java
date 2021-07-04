class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int pos = 0, neg = 0, sum = 0, res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0) {
                res = Math.max(res, Math.abs(sum-pos));
                neg = Math.min(neg, sum);
            }
            else if(sum > 0) {
                res = Math.max(res, Math.abs(sum-neg));
                pos = Math.max(pos, sum);
            }
            else {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}

/*
    [1,-3,2,3,-4]
    [1 -2 0 3 -1]
    
    pos = 1
    neg = -2
    
    [2,-5,1,-4,3,-2]
    [2 -3 -2 -6 -3 -5]


    2
    -6
    
    for negative find highest positive
    for positive find lowest negative
*/

