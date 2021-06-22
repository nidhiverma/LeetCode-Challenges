/*
    @author: Nidhi
    
    Naive Approach:
        for every line i check every line j on its right
        calculate vol of water within (i,j), update maxVol accordingly
        
        for i in [0, n-2]:
            for j in [i+1, n-1]:
                vol = math.min(i, j) * (j-i)
                maxVol = math.max(vol, maxVol)
            
        Time Complexity: O(n^2)
        Space Complexity: O(1)
    
    Efficient Approach: 
        Use Two Pointers.
        i = 0 (start line) 
        j = n-1 (end line)
        
        move i and j towards each other until they become equal
        
        while i < j: 
            calculate vol of water trapped inside bounds (i, j)
            update max volume if current vol > max volume
            
            if height[i] <= height[j] ---> move i to right
            else    ---> move j to left
        
        return max volume
        
        Time Complexity: O(n);
        Space Complexity: O(1)
        
        
*/

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, maxVol = 0;
        
        while(i < j) {
            int vol = Math.min(height[i], height[j]) * (j - i);
            maxVol = Math.max(vol, maxVol);
            
            if(height[i] <= height[j]) {
                i++;
              
            }
            else j--;
        }
        return maxVol;
    }
}