class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        dfs(s, 0, res, new ArrayList());
        return res;
    }
    
    private void dfs(String s, int i, List<List<String>> res, List<String> list) {
        if(i >= s.length()) {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                list.add(s.substring(i, j+1));
                dfs(s, j+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}