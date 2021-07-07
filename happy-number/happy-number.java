// 7 -> 49 -> 81+16 = 97 -> 49+81 = 130 -> 10 -> 
class Solution {
    
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        return isHappy(n, seen);
    }
    
    private boolean isHappy(int n, Set<Integer> seen) {
        if(n == 1) return true;
        if(seen.contains(n)) return false;
        
        seen.add(n);
        
        int sum = 0;
        while(n > 0) {
            sum += Math.pow(n % 10 , 2);
            n /= 10;
        }
        return isHappy(sum, seen);
    }
}