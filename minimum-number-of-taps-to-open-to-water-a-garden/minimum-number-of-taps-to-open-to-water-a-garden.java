/*
    @author: Nidhi
    
    Approach: Similar to Jump Game II
    Build your own jump array

*/
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRight = new int[n+1];
        
        for(int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i-ranges[i]);
            int right = Math.min(n, i+ranges[i]);
            
            //From left to right, gardens can be watered in one go
            maxRight[left] = Math.max(maxRight[left], right);
        }
        
        int currLevel = 0, taps = 0, farthestRange = 0;
        
        for(int i = 0; i <= n; i++) {
            farthestRange = Math.max(farthestRange, maxRight[i]);
            
            if(currLevel == i) {
                taps++;
                currLevel = farthestRange;
            }
            
            if(currLevel >= n) {
                return taps;
            }
        }
        return -1;
    }
}