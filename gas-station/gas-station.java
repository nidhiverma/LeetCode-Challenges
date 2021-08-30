class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0, maxGas = 0, gasLeft = 0;
        
        for(int i = 0; i < n; i++) {
            if(gasLeft >= 0) {
                gasLeft += gas[i] - cost[i];
            }
            else {
                start = i;
                gasLeft = gas[i] - cost[i];
            }
        }
        
        // cannot start from any gas station
        if(gasLeft < 0) return -1;
        
        for(int i = 0; i < start; i++) {
            if(gasLeft >= 0) {
                gasLeft += gas[i] - cost[i];
            }
            else {
                return -1;
            }
        }
        return gasLeft >= 0 ? start : -1;
    }
} 