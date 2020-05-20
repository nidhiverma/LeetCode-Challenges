class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            }
            else {
                map.put(s.charAt(i), i);
                q.add(s.charAt(i));
            }
        }
        
        while(q.size() != 0 && map.get(q.peek()) == -1) {
            q.remove();
        }
        if(q.size() == 0) return -1;
        return map.get(q.peek());
    }
}
