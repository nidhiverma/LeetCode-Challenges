class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        };
        
        Arrays.sort(strs, comp);
        
        if(strs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s: strs) sb.append(s);
        return sb.toString();
    }
}