class Solution {
    class Cell {
        int x, y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Cell> queue = new LinkedList();
        int m = rooms.length, n = rooms[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0)
                    queue.offer(new Cell(i, j));
            }
        }
        
        int[][] dir = new int[][]{{-1, 0}, {1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Cell cell = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int x = cell.x + dir[i][0];
                    int y = cell.y + dir[i][1];
                    
                    if(x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = rooms[cell.x][cell.y] + 1;
                        queue.offer(new Cell(x, y));
                    }
                }
            }
        }
    }
} 