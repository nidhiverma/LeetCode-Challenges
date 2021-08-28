// Time complexity: O(log n)

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long p = n;
        
        if(p < 0) p = -1*p;
        
        while(p > 0) {
            if(p % 2 == 1) {
                ans = ans * x;
                p--;
            }
            else {
                x = x*x;
                p /= 2;
            }
        }
        
        if(n < 0) return 1.0/ans;
        return ans;
    }
}