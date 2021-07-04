class Solution {
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue(); 
        
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> res = new ArrayList(map.values());
        
        Collections.sort(res);
        int i = 0, j = res.size()-1;
        
        while(k-- > 0) {
           if(res.get(i) == 1) {
               i++;
           }
           else {
               res.set(i, res.get(i)-1);
           } 
        }
    
        return res.size()-i;
    }
}