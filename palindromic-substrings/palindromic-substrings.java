class Solution {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();

        char[] str = s.toCharArray();
        
        for(int i = 0; i < n; i++){
            count += helper(str, i, i);
            count += helper(str, i, i+1);
        }
        return count;
    }
    
    private int helper(char[] str, int i, int j) {
        int count = 0;
        while(i >= 0 && j < str.length && str[i--] == str[j++]) {
            count++;
        }
        return count;
    }
}