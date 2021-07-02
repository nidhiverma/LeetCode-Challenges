/*
    @author: Nidhi
    
    Approach:
        Maintain a prefix sum array which store the min length subarray with target sum till index i-1 at index i
        calculate lengths sum at every index at which subarray sum is equal to target, if lengthSum < lengthSumSoFar, update it
        
        if lengthSumSoFar == INF return -1, otherwise return lengthSumSoFar
        
        Time Complexity: O(n)
        Space Complexity: O(n)
*/
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int prefixSum = 0, minLengthSoFar = Integer.MAX_VALUE, result = Integer.MAX_VALUE, start = 0;
        
        int[] prefix = new int[arr.length];
        Arrays.fill(prefix, Integer.MAX_VALUE);
        
        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i]; 
            
            while(prefixSum > target) {
                prefixSum -= arr[start++];
            }
            
            if(prefixSum == target) {
                if(start > 0 && prefix[start-1] != Integer.MAX_VALUE) {
                    result = Math.min(result, prefix[start-1] + i-start+1);
                }
                minLengthSoFar = Math.min(minLengthSoFar, i-start+1);
            }
            prefix[i] = minLengthSoFar;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}