/*
    Time Complexity: O(m+n)    
        ----> m for storin all characters in map
        ----> n is the length of string s, we are traversing the string processing every character in s
        
    Space Complexity: O(n)  ----> if len(s) == len(t) and t contains all unique characters
*/

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0, j = 0, minLength = Integer.MAX_VALUE, count = map.size(), start = -1, end = -1;
        
        while(j < s.length()) {
            char c = s.charAt(j);
            
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                
                if(map.get(c) == 0) {
                    count--;
                }
            }
         
            
            while(count == 0) {        // found every character in t
                if(minLength > j-i+1) {
                    minLength = j-i+1;
                    start = i;
                    end = j;
                }
                
                char k = s.charAt(i);
                if(map.containsKey(k)) {
                    map.put(k, map.get(k)+1);
                    
                    if(map.get(k) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        if(start != -1 && end != -1) return s.substring(start, end+1);
        return "";
    }
}