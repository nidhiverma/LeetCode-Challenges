class Solution {
    Set<Integer> seen = new HashSet();
    
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        
        for (int[] edge: edges) {
            seen.clear();
            
            int a = edge[0];
            int b = edge[1];
            
            if(map.containsKey(a) && map.containsKey(b)) {
                if (!map.get(a).isEmpty() && !map.get(b).isEmpty() && dfs(map, a, b)) {
                    return edge;
                }
            }
           
            map.putIfAbsent(a, new ArrayList());
            map.putIfAbsent(b, new ArrayList());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return new int[0];
    }
    
    public boolean dfs(HashMap<Integer, List<Integer>> map, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei: map.get(source)) {
                if (dfs(map, nei, target)) return true;
            }
        }
        return false;
    }
}