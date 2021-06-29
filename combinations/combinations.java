/*
    @author: Nidhi
    
    Approach:
        Use Backtracking. For every i in range(1,n)
        Add integer i into the current combination curr.
        Proceed to add more integers into the combination : backtrack(i + 1, curr).
        Backtrack by removing i from curr.
        
        Time Complexity: O(k*nCk)
        Space Complexity: O(nCk)

*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        helper(n, k, 1, new ArrayList(), res);
        return res;
    }
    
    private void helper(int n, int k, int idx, List<Integer> combo, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList(combo));
            return;
        }
        
        for(int i = idx; i <= n; i++) {
            combo.add(i);
            helper(n, k-1, i+1, combo, result);
            combo.remove(combo.size()-1);
        }
    }
}