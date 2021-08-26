class Solution {
    public int longestOnes(int[] A, int K) {
        int globalSum = Integer.MIN_VALUE, localSum = 0, flipCount = K, windowStart = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                if(flipCount == 0) {
                    // System.out.println(localSum);
                    if(globalSum < localSum) {
                        globalSum = localSum;
                    } 
                    while(A[windowStart++] == 1) {
                        localSum--;
                    }
                } 
                else {
                    localSum++; 
                    flipCount--;
                }
            }
            else {
                localSum++;
            }
        }
        if(globalSum < localSum) globalSum = localSum;
        return globalSum;
    }
}