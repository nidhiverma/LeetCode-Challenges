class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        
        for(int i = 0; i < piles.length; i++) {
            hi = Math.max(piles[i], hi);
        }
        
        int minSpeed = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(canEat(piles, mid, h)) {
                minSpeed = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return minSpeed;
    }
    
    private boolean canEat(int[] piles, int maxSpeed, int hrs) {
        int hrsTaken = 0;
        
        for(int i = 0; i < piles.length; i++) {
            hrsTaken += Math.ceil(piles[i]/(double) maxSpeed);
        }
        return hrsTaken <= hrs;
    }
}