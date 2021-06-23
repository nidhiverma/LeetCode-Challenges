/*
    @author: Nidhi
    
    Approach: 
        Store the index of last occurence of each character in an array/map
        traverse the string from left to right
        for each character check its last index
            if last index == current index 
                a new partition is found, add its size in the result list
            else
                update current partition end if last index > partition end
        
        Time Complexity: O(n)
        Space Complexity: O(n)
    

*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastOccurence = new HashMap();
        
        
        // store last occurence of each character in string s in hashmap 
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastOccurence.put(c, i);
        }
        
        int partitionStart = 0, partitionEnd = -1, idx = 0;
        List<Integer> partitions = new ArrayList(); 
        
        while(idx < s.length()) {
            char c = s.charAt(idx);
            
            int lastIndex = lastOccurence.get(c);
            
            partitionEnd = Math.max(partitionEnd, lastIndex);
            
            if(idx == partitionEnd) {
                partitions.add(partitionEnd-partitionStart+1);
                partitionStart = partitionEnd+1;
                partitionEnd = -1;
            }
            idx++;
        }
        return partitions;
        
    }
}