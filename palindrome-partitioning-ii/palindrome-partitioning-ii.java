class Solution {
    public int minCut(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length()-1, dp);
    }
    
    private int helper(String s, int i, int j, Integer[][] dp) {
        if(i >= j || isPalindrome(s, i, j)) return 0;
        
        if(dp[i][j] != null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++) {
            if(isPalindrome(s, i, k))
                ans = Math.min(ans, 1 + helper(s, k+1, j, dp));
        }
        dp[i][j] = ans;
        return ans;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }  
}