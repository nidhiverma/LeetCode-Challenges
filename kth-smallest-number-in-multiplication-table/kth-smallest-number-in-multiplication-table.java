class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m*n, ans = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isFeasible(m, n, mid, k)) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return ans;
    }
    
    private boolean isFeasible(int m, int n, int val, int k) {
        int count = 0;
        
        for(int i = 1; i <= m; i++) {
            int smallerNums = Math.min(val/i, n);
            if(smallerNums == 0) break;
            count += smallerNums;
        }
        return count >= k;
    }
}