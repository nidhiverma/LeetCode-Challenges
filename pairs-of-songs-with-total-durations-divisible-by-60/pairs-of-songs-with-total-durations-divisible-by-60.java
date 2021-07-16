class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        
        for(int t = 0; t < time.length; t++) {
            
            if(time[t] % 60 == 0) {
                count += remainders[0];
            }
            else {
                count += remainders[60 - time[t] % 60];
            }
            remainders[time[t] % 60]++;
        }
        return count;
    }
}
