class Solution {
    Boolean[][] dp;
    Boolean[][] pal;
    public boolean checkPartitioning(String s) {
        dp = new Boolean[s.length()][4];
        pal = new Boolean[s.length()][s.length()];
        return helper(s, 0, 3);
    }
    
    private boolean helper(String s, int start, int k) {
        if(start >= s.length()) {
            return k == 0;
        }
        
        if(dp[start][k] != null) return dp[start][k];
        
        if(k == 1) return isPalindrome(s, start, s.length()-1);
                
        for(int end = start+1; end < s.length(); end++) {
            if(isPalindrome(s, start, end-1)) {
                if(helper(s, end, k-1)) {
                    dp[start][k] = true;
                    return true;
                }
            }
        }
        dp[start][k] = false;
        return false;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        // while(i < j) {
        //     if(s.charAt(i++) != s.charAt(j--)) return false;
        // }
        if(i >= j) return true;
        
        if(pal[i][j] != null) return pal[i][j];
        pal[i][j] = s.charAt(i) == s.charAt(j) ? isPalindrome(s, i+1, j-1) : false;
        
        return pal[i][j];
    }
}