class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        
        int[][] res = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int aliveNeighbors = countAliveNeighbors(board, i, j);
                
                if(board[i][j] == 1 && (aliveNeighbors == 2 || aliveNeighbors == 3)) res[i][j] = 1;
                else if(board[i][j] == 0 && aliveNeighbors == 3) res[i][j] = 1;
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
    int[][] dir = new int[][] {{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};
    
    private int countAliveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        
        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                count += board[x][y];
            }
        }
        return count;
    }
}

// cell = 1 neighbors < 2 || > 3 die
// cell = 1 2 <= neighbors <= 3 lives
// cell = 0 neighbors = 3 live