class Solution {
    
    int[] low, ids;
    boolean[] visited;
    List<List<Integer>> result = new ArrayList();
    int id = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = buildGraph(n, connections); 
        visited = new boolean[n];
        ids = new int[n];
        Arrays.fill(ids, -1);
        
        dfs(graph, 0, -1);
        return result;
    }
    
    private void dfs(List<List<Integer>> graph, int at, int parent) {
        visited[at] = true;
        ids[at] = id++;
        int currentId = ids[at];
        
        List<Integer> adj = graph.get(at);
        for(int to : adj) {
            if(to == parent) continue;
            if(!visited[to]) dfs(graph, to, at);
            ids[at] = Math.min(ids[at], ids[to]);
            if(currentId < ids[to]) result.add(Arrays.asList(at, to));
        }
    }
    
    private List<List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }
        
        for(List<Integer> edge: connections) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        return graph;
    }
} 