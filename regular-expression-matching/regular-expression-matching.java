class Solution {
    private boolean helper(char[] s, char[] p, int i, int j){
        if(j >= p.length) {
            return i >= s.length;
        }
        if(i == s.length){
            if(j+1 >= p.length || p[j+1] != '*') return false;
            return helper(s, p, i, j+2);
        }
        if(j+1 == p.length){
            if(p[j] != s[i] && p[j] != '.') return false;
            return helper(s, p, i+1, j+1);
        }
        if(p[j+1] != '*'){
            if(p[j] == '.' || p[j] == s[i]) return helper(s, p, i+1, j+1);
            return false;
        }
        
        boolean ans = helper(s, p, i, j+2);
        if(p[j] == '.' || s[i] == p[j]){
            ans = ans || helper(s, p, i+1, j);
        }
        return ans;
    }
    public boolean isMatch(String s, String p) {
        return helper(s.toCharArray(), p.toCharArray(), 0, 0);
    }
}