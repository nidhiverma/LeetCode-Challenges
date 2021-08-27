class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        
        helper(nums, 0, new ArrayList(), res);
        return res;
    }
    
    private void helper(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList(subset));
        
        for(int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i+1, subset, res);
            subset.remove(subset.size()-1);
        }
    }
}