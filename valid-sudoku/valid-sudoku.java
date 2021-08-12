class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList();
        List<Set<Character>> cols = new ArrayList();
        List<Set<Character>> boxes = new ArrayList();
        
        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet());
            cols.add(new HashSet());
            boxes.add(new HashSet());
        }
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                
                if(c != '.') {
                    if(rows.get(i).size() > 0 && rows.get(i).contains(c) || 
                       cols.get(j).size() > 0 && cols.get(j).contains(c) || 
                       boxes.get(3*(i/3) + j/3).size() > 0 && boxes.get(3*(i/3) + j/3).contains(c)) {
                        
                        return false;
                    }
                     
                    rows.get(i).add(c);
                    cols.get(j).add(c);
                    boxes.get(3*(i/3) + j/3).add(c);   
                }
            }
        }
        
        return true;
    }
}