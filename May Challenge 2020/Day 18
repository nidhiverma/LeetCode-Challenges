class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int keyLen = s1.length();
        int valueLen = s2.length();
        if(keyLen > valueLen)
            return false;
        
        char[] countKey = new char[26];
        char[] countValue = new char[26];
       
        for(int i = 0; i < keyLen; i++) {
            countKey[s1.charAt(i)-'a']++;
            countValue[s2.charAt(i)-'a']++;
        }
        for(int i = keyLen; i< valueLen; i++) {
            if(match(countKey, countValue)) {
                return true;
            }
            countValue[s2.charAt(i)-'a']++;
            countValue[s2.charAt(i-keyLen)-'a']--;
        }
        if(match(countKey, countValue))
           return true;
        return false;       
    }
    
    private boolean match(char[] key, char[] value){
        for(int i = 0; i < 26; i++){
            if(key[i] != value[i]){
                return false;
            }
        }
        return true;
    }
}
