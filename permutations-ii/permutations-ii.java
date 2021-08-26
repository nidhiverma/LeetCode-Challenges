class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, visited, new ArrayList());
        return res;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> perm) {
        if(nums.length == perm.size()) {
            res.add(new ArrayList(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            
            visited[i] = true;
            perm.add(nums[i]);
            helper(nums, visited, perm);
            perm.remove(perm.size()-1);
            visited[i] = false;
        }
    }
}