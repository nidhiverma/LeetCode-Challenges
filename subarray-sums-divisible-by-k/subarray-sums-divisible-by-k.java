class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> prefixSumFrequencyMap = new HashMap();
        prefixSumFrequencyMap.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            if(prefixSum < 0) {
                int temp = Math.abs(prefixSum) % k;
                if(temp == 0) temp = k;
                prefixSum = k - temp;
            }
            else {
                prefixSum %= k;
            }
            if(prefixSumFrequencyMap.containsKey(prefixSum)) {
                count += prefixSumFrequencyMap.get(prefixSum);
            }
            prefixSumFrequencyMap.put(prefixSum, prefixSumFrequencyMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}