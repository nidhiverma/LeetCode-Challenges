/*
    @author: Nidhi 
    
    Naive approach: 
        For every index i, check for every substring starting at index i
        Time Complexity: O(n^3) ---> O(n^2) for generating every substring, O(n) for checking valid substring
        Space Complexity: O()
    
    Optimized approach: 
        Use sliding window approach. 
        i = 0, j = 0 ( i = sliding window start, j = sliding window end)
        
        Keep track of the last index of every character 'c' seen so far in the substring.
        
        for i in (0, n-1):
            If seen(c) && if the last seen index lies inside the current window bounds
                maxLength = math.max(maxLength, j - i)     ---->     update maxLength
                i = lastIndex(c)+1                           ---->     slide the window
                lastIndex(c) = j                           ---->     update lastIndex of c 

            otherwise, if lastindex lies outside window bounds, it means c hasn't occured previously in the current window
                lastIndex(c) = j
                
        maxLength = math.max(maxLength, j - i)
        
        Time Complexity: O(n)
        Space Complexity: O(min(m, n))      (n = s.length(), m = maxLength of longest substring with unique characters)
    
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap();
        
        int i = 0, j = 0, maxLen = 0;
        
        while(j < s.length()) {
            char c = s.charAt(j);
            
            if(lastIndex.containsKey(c) && lastIndex.get(c) >= i) {
                maxLen = Math.max(maxLen, j-i);
                i = lastIndex.get(c)+1;
                lastIndex.put(c, j);
            }
            else {
                lastIndex.put(c, j);
            }
            j++;
        }
        maxLen = Math.max(maxLen, j-i);
        return maxLen;
    }
}