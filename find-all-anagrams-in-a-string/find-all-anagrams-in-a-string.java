class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap();
        
        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int i = 0, j = 0, count = map.size();
        List<Integer> res = new ArrayList();
        
        while(j < s.length()) {
            char c = s.charAt(j);
            
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) count--;
            }
            
            while(count == 0) {
                char start = s.charAt(i);
                
                if(map.containsKey(start)){
                    map.put(start, map.get(start) + 1);
                    
                    if(map.get(start) > 0){
                        count++;
                    }
                }
                if(j-i+1 == p.length()){
                    res.add(i);
                }
                i++;
            }
            
            j++;
        }
        return res;
    }
}