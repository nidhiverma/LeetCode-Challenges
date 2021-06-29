class Solution {
    class Pair {
        int node;
        double prob;
        
        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = buildGraph(n, edges, succProb);
        
        double[] prob = new double[n];
        prob[start] = 1.0;
        
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            List<Pair> neighbors = graph.get(curr);
            
            for(Pair neighbor : neighbors) {
                if(neighbor.prob * prob[curr] > prob[neighbor.node]) {
                    prob[neighbor.node] = neighbor.prob * prob[curr];
                    queue.offer(neighbor.node);
                }
            }
        }
        
        return prob[end];
    }
    
    private Map<Integer, List<Pair>> buildGraph(int n, int[][] edges, double[] succProb) {
        Map<Integer, List<Pair>> graph = new HashMap();
        
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Pair>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            graph.get(v1).add(new Pair(v2, succProb[i]));
            graph.get(v2).add(new Pair(v1, succProb[i]));
        }
        return graph;
    }
}