class Solution {
    
    // map to store all sentences starting at index i
    Map<Integer, List<String>> map = new HashMap();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, int start) {
        if(map.containsKey(start)) return map.get(start);
        
        List<String> result = new ArrayList();
        if(start == s.length()) return result;
        
        // check for every possible prefix
        for(int end = start+1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            
            // if prefix is a valid word, get all the valid sentences starting with this prefix
            if(wordDict.contains(prefix)) {
                List<String> sentences = wordBreakHelper(s, wordDict, end);
                
                if(sentences.size() != 0) {
                    sentences = sentences.stream().map(str -> prefix + " " + str).collect(Collectors.toList());
                    result.addAll(sentences);
                }
                else if(end == s.length()) {
                    result.add(prefix);
                }
            }
        }
        
        map.put(start, result);
        return result;
    }
}