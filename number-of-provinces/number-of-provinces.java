class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        
        for(int i = 0;  i < isConnected.length; i++) {
            if(visited[i] == 0) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i, int[] visited) {
        if(visited[i] == -1) return;
        
        visited[i] = -1;
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == 1 && visited[j] == 0) {
                dfs(grid, j, visited);
            }
        }
        visited[i] = 1;
    }
}