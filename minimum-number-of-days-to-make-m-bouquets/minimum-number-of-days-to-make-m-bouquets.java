class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;        // not enough flowers to make m bouquets
        
        int lo = 1, hi = 0;
        
        for(int i = 0; i < bloomDay.length; i++) {
            hi = Math.max(hi, bloomDay[i]);
        }
        
        int days = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isFeasible(bloomDay, mid, m, k)) {
                days = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return days;
    }
    
    private boolean isFeasible(int[] bloomDays, int day, int m, int k) {
        int flowers = 0;
        
        for(int i = 0; i < bloomDays.length; i++) {
            if(bloomDays[i] <= day) {
                flowers++;
                
                if(flowers == k) {
                    m--;
                    flowers = 0;
                }
                
                if(m == 0) return true;
            }
            else {
                flowers = 0;
            }
        }
        
        return false;
    }
}