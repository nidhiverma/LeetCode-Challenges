class Solution {
    public boolean isPerfectSquare(int num) {
        int onesDigit = num % 10;
        if(onesDigit == 2 || onesDigit == 3 || onesDigit == 7 || onesDigit == 8) {
            return false;
        }
        
        for(int i = 1; i*i <= num; i++) {
            if(i*i == num) {
                return true;
            }
        }
        return false;
    }
}
