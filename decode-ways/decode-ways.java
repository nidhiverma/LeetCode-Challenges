class Solution {
    public int numDecodings(String s) {
        int[] lookup = new int[s.length()];
        Arrays.fill(lookup, -1);
        return helper(s, lookup, 0);
    }
    
    public int helper(String s, int[] lookup, int index) {
        if(s.length() == index) return 1;
        if(s.charAt(index) == '0') return 0;
        
        if(lookup[index] != -1) {
            return lookup[index];
        }
        
        int count = 0;
        count += helper(s, lookup, index+1);
        
        if(s.length() > index+1) {
            if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) <= '6')) {
                count += helper(s, lookup, index+2);
            }
        }
        lookup[index] = count;
        return lookup[index];
    }
    
}