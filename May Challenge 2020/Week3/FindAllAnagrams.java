class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        
        if(sLen < pLen) return output;
        
        char[] pCount = new char[26];
        char[] sCount = new char[26];
        
        for(int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        
        for(int i = pLen; i < sLen; i++) {
            if(match(sCount, pCount)) {
                output.add(i-pLen);
            }
            sCount[s.charAt(i)-'a']++;
            sCount[s.charAt(i-pLen)-'a']--;
        }
        
        if(match(sCount, pCount)) {
            output.add(sLen-pLen);
        }
        return output;
    }
    
    private boolean match(char[] s, char[] p) {
        for(int i = 0; i < 26; i++) {
            if(s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}
