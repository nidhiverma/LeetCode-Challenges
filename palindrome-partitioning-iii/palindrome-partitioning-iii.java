class Solution {
    Integer[][] palDP;
    Integer[][] dp;
    
    public int palindromePartition(String s, int k) {
        int len = s.length();
        palDP = new Integer[len][len];
        dp = new Integer[len+1][k+1];
        
        return helper(s, 0, k);
    }
    
    private int helper(String s, int start, int k) {
        // System.out.println(s + " " + start + " " + k);
        if(s.length()-start == k) return 0;
        
        if(k == 1) {
            return changes(s, start, s.length()-1);
        }
        
        if(dp[start][k] != null) return dp[start][k];
        
        int min = Integer.MAX_VALUE;
        
        for(int end = start+1; end < s.length()-k+2; end++) {
            min = Math.min(min, changes(s, start, end-1) + helper(s,end, k-1));
            if(min == 0) {
                dp[start][k] = 0;
                return 0;
            }
        }
        dp[start][k] = min;
        return min;
    }
    
    public int changes(String s, int i, int j) {
        if(i >= j) return 0;
        int cost = 0;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                cost++;
            }
        }
        return cost;
    }
}
