class Solution {
    public void solveSudoku(char[][] board) {
        solveBoard(board);
    }
    
    private boolean solveBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(isValidSudoku(board, i, j, k)) {
                            board[i][j] = k;
                            
                            if(solveBoard(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int r, int c, char k) {
        for(int i = 0; i < 9; i++) {
            if(board[r][i] == k) return false;
            if(board[i][c] == k) return false;
            if(board[3*(r/3) + i/3][3*(c/3)+ i%3] == k) return false;
        }
        return true;
    }
}