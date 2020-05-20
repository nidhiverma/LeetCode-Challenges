class Solution {
    public int majorityElement(int[] nums) {
        double max_count = Math.floor(nums.length/2);
        // Set<Integer> output = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            }
            else {
                int value = map.get(i) + 1;
                if(value > max_count) {
                    return i;
                }
                map.put(i, value);
            }
        }
        
        return nums[0];
    }
}
