class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        
        return helper(s, 0, s.length(), wordDict, memo);
    }
    
    private boolean helper(String s, int i, int j, List<String> wordDict, int[] memo) {
        if(i > j || wordDict.contains(s.substring(i, j))) return true;
        
        if(memo[i] != -1) return memo[i] == 1;
        
        for(int k = i; k < j; k++) {
            if(wordDict.contains(s.substring(i, k+1))) {
                if(helper(s, k+1, j, wordDict, memo)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }
}