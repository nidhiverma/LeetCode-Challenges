class UnionFind {
    int[] parent;
    int[] size;
    
    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int city) {
        int root = city;
        while(root != parent[root]) {
            root = parent[root];
        }
        
        // path compression
        while(city != root) {
            int next = parent[city];
            parent[city] = root;
            city = next;
        }
        return root;
    }
    
    public boolean isConnected(int city1, int city2) {
        return find(city1) == find(city2);
    }
    
    public int getSize(int city) {
        return size[find(city)];
    }
    
    public void union(int city1, int city2) {
        int root1 = find(city1);
        int root2 = find(city2);
        
        if(root1 == root2) return;
        
        if(size[root1] >= size[root2]) {
            size[root1] += size[root2];
            parent[root2] = root1;
        }
        else if(size[root1] < size[root2]) {
            size[root2] += size[root1];
            parent[root1] = root2;
        }
    }
}

class Solution {
    
    public int minimumCost(int n, int[][] connections) {
        if(connections.length == 0) return 0;
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(n+1);
        int totalCost = 0;
        
        for(int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int cost = connection[2];
            
            if(uf.isConnected(from, to)) continue;
            
            // connect cities
            uf.union(from, to);
            totalCost += cost;
            
            // all cities connected
            if(uf.getSize(1) == n) break;
        }
        System.out.println(Arrays.toString(uf.parent));
        if(uf.getSize(1) != n) return -1;
        return totalCost;
        
    }
    
    
}