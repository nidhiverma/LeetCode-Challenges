class Solution {
    class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        if(m == 1 && n == 1) return grid[0][0] == 0 ? 1 : -1;
        
        int[][] dir = new int[][] {{1,0}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,-1}, {0,-1}, {-1,-1}};
        
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(0,0));
        int dist = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Pair p = queue.poll();
                
                for(int[] d: dir) {
                    int x = d[0] + p.x, y = d[1] + p.y;
                    
                    if(isValid(m, n, x, y) && grid[x][y] == 0) {
                        if(x == m-1 && y == n-1) {
                            return dist+1;
                        }
                        queue.offer(new Pair(x, y));
                        grid[x][y] = -1;
                    }
                }
            }
            dist++;
        }
        return -1;
    }
    
    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}