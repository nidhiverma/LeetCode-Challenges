class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        
        int maxLen = 0, start = -1, end = -1;
        
        for(int i = 0; i < s.length()-1; i++) {
            int pal1 = helper(s, i, i);
            int pal2 = helper(s, i, i+1);
            
            if(pal1 > maxLen) {
                if(pal1 >= pal2) {
                    maxLen = pal1;
                    start = i - pal1/2;
                    end = i + pal1/2;
                }
                else {
                    maxLen = pal2;
                    start = i - (pal2/2)+1;
                    end = i + pal2/2;
                }
            } 
            else if(pal2 > maxLen) {
                maxLen = pal2;
                start = i - (pal2/2)+1;
                end  = i + pal2/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int helper(String s, int lo, int hi) {
        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        if(lo < 0) {
            return hi;
        }
        return hi-lo-1;
    }
}  