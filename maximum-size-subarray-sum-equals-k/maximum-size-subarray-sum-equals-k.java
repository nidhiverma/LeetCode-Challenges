class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int i = 0, j = 0, len = -1, sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        
        while(j < nums.length) {
            sum += nums[j];
            
            map.putIfAbsent(sum, j+1);
            
            if(map.containsKey(sum-k)) {
                len = Math.max(len, j-map.get(sum-k)+1);
            }
            j++;
        }
        
        return len == -1 ? 0 : len;
    }
}