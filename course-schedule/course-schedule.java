/*
    @author: Nidhi
    
    Approach: Topological Sorting 

*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();
        
      
        // O(E)
        for(int[] p : prerequisites) {
            map.putIfAbsent(p[0], new ArrayList());
            map.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        
        // O(V)
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty() && numCourses > 0) {
            int size = queue.size();
            
            while(size-- > 0) {
                int cid = queue.poll();
                numCourses--;
                
                if(!map.containsKey(cid)) continue;
                
                List<Integer> dependents = map.get(cid);
                for(int dependent: dependents) {
                    indegree[dependent]--;
                    if(indegree[dependent] == 0) queue.offer(dependent);
                }
            }
        }
        
        return numCourses == 0;
    }
    
    
}