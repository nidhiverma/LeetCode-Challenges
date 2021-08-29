class Solution {
    class Move {
        int val;
        int dist;
        
        public Move(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Move> queue = new LinkedList();
        queue.offer(new Move(1,0));
        boolean[] visited = new boolean[n*n + 1];
        int start = 1;
        int target = n*n;
        
        
        while(!queue.isEmpty()) {
            Move move = queue.poll();
            int val = move.val;
            int dist = move.dist;
            visited[val] = true;
            if(val == target) {
                return move.dist;
            }
            
            for(int i = 1; i <= 6 && val+i <= target; i++) {
                int dest = getBoardValue(board, val+i);
                
                if(dest == -1) {
                    if(!visited[val+i]) queue.offer(new Move(val+i, dist+1));
                }
                else {
                    //int newVal = getBoardValue(board, dest);
                    if(!visited[dest]) queue.offer(new Move(dest, dist+1));
                }
            }
            
        }
        return -1;
    }
    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y;
        if(n % 2 == 0){
            y = x % 2 == 0 ? n - 1 - ((num-1) % n)  : (num-1) % n;   
        }
        else{
            y = x % 2 != 0 ? n - 1 - ((num-1) % n)  : (num-1) % n;  
        } 
        return board[x][y];
    }
}