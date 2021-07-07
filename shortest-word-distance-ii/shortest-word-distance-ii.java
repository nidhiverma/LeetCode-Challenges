class WordDistance {

    Map<String, List<Integer>> map;
    String[] wordsDict;
    
    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
        this.map = new HashMap();
        
        fillMap();
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int minDiff = Integer.MAX_VALUE, i = 0, j = 0; 
        
        while(i < list1.size() && j < list2.size()) {
            minDiff = Math.min(minDiff, Math.abs(list1.get(i) - list2.get(j)));
            
            if(list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return minDiff;
    }
    
    private void fillMap() {
        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            
            map.putIfAbsent(word, new ArrayList());
            map.get(word).add(i);
        }
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */