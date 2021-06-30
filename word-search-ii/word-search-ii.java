class Solution {
    class TrieNode {
        String val;
        boolean isTerminating;
        TrieNode[] children;
        
        public TrieNode() {
            val = "";
            isTerminating = false;
            children = new TrieNode[26];
        }
        
        public void insert(TrieNode root, String word, int idx) {
            if(idx == word.length()) {
                root.isTerminating = true;
                root.val = word;
                return;
            }
            
            if(root.children[word.charAt(idx)-'a'] == null) {
                root.children[word.charAt(idx)-'a'] = new TrieNode();
            }
            insert(root.children[word.charAt(idx)-'a'], word, idx+1);
        }
        
    }
    
    int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'){
            return;
        }
        
        TrieNode child = root.children[board[i][j] - 'a'];
        
        if(child == null) return;
        
        if(child.isTerminating){
            String val = child.val;
            if(!res.contains(val)) res.add(val);
        }
              
        char temp = board[i][j];
        board[i][j] = '#';
        
        for(int[] d: dir) {
             dfs(board, i+d[0], j+d[1], child, res);
        }
       
        board[i][j] = temp;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList();
      
        for(String word : words){
            root.insert(root, word, 0);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    
    
//     public List<String> findWords(char[][] board, String[] words) {
//         int m = board.length, n = board[0].length;
        
//         HashMap<Character, List<List<Integer>>> map = new HashMap();
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 char c = board[i][j];
//                 map.putIfAbsent(c, new ArrayList());
//                 map.get(c).add(Arrays.asList(i,j));
//             }
//         }
        
//         List<String> res = new ArrayList();
//         Set<String> targetWords = new HashSet();
        
//         for(String word: words) {
//             if(!map.containsKey(word.charAt(0))) continue;
//             if(targetWords.contains(word)) continue;
//             targetWords.add(word);
            
//             if(findWord(word, map.get(word.charAt(0)), board)) {
//                 res.add(word);   
//             }
//         }
//         return res;
//     }
     
    
//     int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
//     private boolean findWord(String word, List<List<Integer>> coords, char[][] board) {
//         for(List<Integer> coord : coords) {
//             if(findWordHelper(word, 0, coord.get(0), coord.get(1), board)) {
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     private boolean findWordHelper(String word, int idx, int i, int j, char[][] board) {
//         // word found
//         if(idx == word.length()) return true;
        
//         // boundary check
//         if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        
//         // already visited or wrong match character
//         if(board[i][j] == '#' || board[i][j] != word.charAt(idx)) return false;
        
//         char val = board[i][j];
        
//         board[i][j] = '#';
        
//         for(int[] d: dir) {
//             if(findWordHelper(word, idx+1, i+d[0], j+d[1], board)) {
//                 board[i][j] = val;
//                 return true;    
//             }
//         }
        
//         board[i][j] = val;
//         return false;
//     }
}