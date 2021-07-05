/*
    Approach: Binary Search
        lo = 1 hi = INT_MAX
        mid = (lo + hi)/2
        
        Count all multiples of a, b, c, ab, ac, bc, abc which are <= mid
        total unique multiples = a+b+c - (ab+bc+ac) + (abc)
        
        if count >= n hi = mid
        else lo = mid+1
        
        return lo
*/

class Solution {
    long ab = 0, bc = 0, ca = 0, abc = 0;
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        
        ab = lcm(a,b);
        bc = lcm(b,c);
        ca = lcm(a,c);
        abc = lcm(a, bc);
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            if(countUglyNums(mid, a, b, c) >= n) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
    
    private int countUglyNums(long mid, long a, long b, long c) {
        int mul_a = (int) (mid / a);
        int mul_b = (int) (mid / b);
        int mul_c = (int) (mid / c);
        int mul_ab = (int) (mid / ab);
        int mul_bc = (int) (mid / bc);
        int mul_ac = (int) (mid / ca);
        int mul_abc = (int) (mid / abc);
        
        return mul_a + mul_b + mul_c - (mul_ab + mul_bc + mul_ac) + mul_abc;
        
    }
    
    private long lcm(long a, long b) {
        return (a*b) / gcd(a,b);
    }
    
    private long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}