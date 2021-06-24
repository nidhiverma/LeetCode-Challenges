class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0]-interval2[0]);
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            int prevStart = res.get(res.size()-1)[0];
            int prevEnd = res.get(res.size()-1)[1];
            
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            
            if(currStart > prevEnd) {
                res.add(intervals[i]);
            }
            else {
                res.set(res.size()-1, new int[]{Math.min(prevStart, currStart), Math.max(prevEnd, currEnd)}); 
            }
        }
        return res.toArray(new int[0][]);
        
    }
}