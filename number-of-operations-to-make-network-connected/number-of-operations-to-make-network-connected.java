class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        
        if(edges < n-1) return -1;
        
        Map<Integer, List<Integer>> network = new HashMap();
        
        for(int i = 0; i < n; i++) {
            network.put(i, new ArrayList());
        }
        
        for(int[] connection : connections) {
            network.get(connection[0]).add(connection[1]);
            network.get(connection[1]).add(connection[0]);
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            exploreNetwork(network, i, visited);
            components++;
        }
        
        int extractedCables = components - 1;
        return extractedCables;
    }
    
    private void exploreNetwork(Map<Integer, List<Integer>> network, int nodeId, boolean[] visited) {
        if(visited[nodeId]) return;
        
        visited[nodeId] = true;
        
        for(int neighborId : network.get(nodeId)) {
            exploreNetwork(network, neighborId, visited);
        }
    }
}
