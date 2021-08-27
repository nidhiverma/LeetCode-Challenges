class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> left = new HashSet();
        Set<Integer> right = new HashSet();
        Set<Integer> col = new HashSet();
        
        List<List<String>> ans = new ArrayList();
        
        helper(0, n, new ArrayList(), ans, left, right, col);
        return ans;
    }
    
    private void helper(int r, int n, List<String> sol, List<List<String>> ans, Set<Integer> left, Set<Integer> right, Set<Integer> col) {
        if(n == r) {
            ans.add(new ArrayList(sol));
            return;
        }
        
        char[] row = new char[n];
        Arrays.fill(row, '.');
        
        for(int i = 0; i < n; i++) {
            if(left.contains(r-i) || right.contains(r+i) || col.contains(i)) continue;
            
            row[i] = 'Q';
            left.add(r-i);
            right.add(r+i);
            col.add(i);
            
            sol.add(String.valueOf(row));
            helper(r+1, n, sol, ans, left, right, col);
            sol.remove(sol.size()-1);
            
            row[i] = '.';   
            left.remove(r-i);
            right.remove(r+i);
            col.remove(i);
            
        }
    }
    
} 