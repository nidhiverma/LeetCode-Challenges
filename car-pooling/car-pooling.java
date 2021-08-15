class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] start = new int[trips.length][2];
        int[][] end = new int[trips.length][2];
        
        for(int i = 0; i < trips.length; i++) {
            start[i] = new int[] {trips[i][1], trips[i][0]};
            end[i] = new int[] {trips[i][2], trips[i][0]};
        }
        
        Arrays.sort(start, (t1, t2) -> t1[0] - t2[0]);
        Arrays.sort(end, (t1, t2) -> t1[0] - t2[0]);        
        
        int i = 0, j = 0, n = trips.length;
        int total = 0;
        
        while(i < n) {
            while(j < n && end[j][0] <= start[i][0]) {
                total -= end[j][1];
                j++;
            }
            total += start[i][1];
            i++;
            if(total > capacity) return false;
        }
        return true;
        
    }
}