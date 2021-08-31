class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // apply bfs
        /*
            -> maintain a set of all words in the wordlist
            -> if endword not in set, return 0
            -> create a queue, put the beginword in the queue
            -> while the queue is not empty, do the following:
                -> traverse all the strings in current queue state
                    -> for ith word, traverse all the characters
                        -> for jth character of ith string, 
                            replace jth character with (a-z), where replaced char is different from
                            jth character itself
                            
                            if new string formed == endstring, return level+1
                            if new string is one the valid transformation(check set values), 
                                add this new string to the queue
                                remove this new string from set (duplicates are not allowed)
                        -> restore ith word
                -> level++
        */
        
        Set<String> set = new HashSet();
        set.addAll(wordList);
        
        if(!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        
        int level = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] wordArray = currWord.toCharArray();
                
                for(int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == originalChar) continue;
                        
                        wordArray[j] = c;
                        String newWord = String.valueOf(wordArray);
                        
                        if(newWord.equals(endWord)) {
                            // System.out.println(newWord);
                            return level+1;
                        }
                        if(set.contains(newWord)) {
                            // System.out.println(newWord);
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}