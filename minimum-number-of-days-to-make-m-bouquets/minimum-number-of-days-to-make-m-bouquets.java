class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        
        int lo = 1, hi = 1, ans = -1;
        
        for(int i = 0; i < bloomDay.length; i++) {
            hi = Math.max(bloomDay[i], hi);
        }
        
        
        while(lo <= hi) {
            int day = lo + (hi - lo + 1)/2;
            
            if(checkPossiblilty(bloomDay, m, k, day)) {
                hi = day-1;
                ans = day;
            }
            else {
                lo = day+1;
            }
        }
        return ans;
    }
    
    // method to check if it is possible to prepare m bouquets by day d
    private boolean checkPossiblilty(int[] bloomDay, int m, int k, int d) {
        int flowersPicked = 0;
        
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= d) {
                flowersPicked++;
            }
            else {
                flowersPicked = 0;
            }
            
            // one bouquet can be made
            if(flowersPicked == k) {
                m--;
                flowersPicked = 0;
            }
            
            if(m == 0) return true;
        }
        return false;
    }
}