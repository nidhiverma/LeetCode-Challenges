class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                boundaryCheck(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                boundaryCheck(board, i, n-1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                boundaryCheck(board, 0, i);
            }
            if(board[m-1][i] == 'O') {
                boundaryCheck(board, m-1, i);
            }
        }
        
        // for(char[] b: board){
        //     System.out.println(Arrays.toString(b));
        // }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
                
            }
        }
    }
    
    int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public void boundaryCheck(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == '*') return;
        
        if(board[i][j] == 'O') {
            board[i][j] = '*';
        
            for(int[] d: dir) {
                boundaryCheck(board, i+d[0], j+d[1]);
            }
        }
    }
}