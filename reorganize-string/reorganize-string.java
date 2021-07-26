class Solution {
    class Pair {
        char c;
        int f;
        public Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        
        int max = 0, letter = 0;
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            freq[c - 'a']++;
            max = Math.max(max, freq[c-'a']);
            if(max == freq[c-'a']) letter = i;
        } 
        
        // can't be reorganized
        if (max > (s.length() + 1) / 2) {
            return ""; 
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.f - a.f;
            }
        });
                                                   
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new Pair((char)(i+'a'), freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            Pair curr = pq.poll();
            Pair next = pq.poll();
            sb.append(curr.c);
            sb.append(next.c);
            freq[curr.c-'a']--;
            freq[next.c-'a']--;
            
            if(freq[curr.c-'a'] > 0) {
                pq.offer(new Pair(curr.c, freq[curr.c-'a']));
            }
            if(freq[next.c-'a'] > 0) {
                pq.offer(new Pair(next.c, freq[next.c-'a']));
            }
        }
        if(pq.size() > 0) sb.append(pq.poll().c);
        return sb.toString();
    }
}