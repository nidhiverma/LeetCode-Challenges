class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] arr = new char[26];
            for(char c: str.toCharArray()) {
                arr[c-'a']++;
            }
            String key = String.valueOf(arr);
            
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(str);     
        }
        return new ArrayList(map.values());
    }
}