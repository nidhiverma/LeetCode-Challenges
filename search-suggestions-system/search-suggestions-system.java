class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products.length == 0 || searchWord.length() == 0) return new ArrayList();
        
        Arrays.sort(products);
        
        List<List<String>> res = new ArrayList();
        
        for(int i = 1; i <= searchWord.length(); i++) {
            String search = searchWord.substring(0, i);
            // System.out.println(search);
            int idx = binarySearch(products, search);
            if(idx == -1) {
                res.add(new ArrayList());
            }
            else {
                List<String> smallRes = new ArrayList();
                for(int j = idx; j < idx+3 && j < products.length && products[j].startsWith(search); j++) {
                    smallRes.add(products[j]);
                    if(smallRes.size() == 3) break;
                }
                res.add(smallRes);
            }
        }
        return res;
    }
    
    private int binarySearch(String[] words, String word) {
        int lo = 0, hi = words.length-1;
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(words[mid].startsWith(word)) {
                hi = mid;
            }
            else if(words[mid].compareTo(word) > 0) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        // System.out.println(lo + " " + words[lo]);
        if(!words[lo].startsWith(word)) return -1;
        return lo;
    }
} 