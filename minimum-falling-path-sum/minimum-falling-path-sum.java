class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        
        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int minSum = matrix[i+1][j];
                if(j-1 >= 0) minSum = Math.min(minSum, matrix[i+1][j-1]);
                if(j+1 < n) minSum = Math.min(minSum, matrix[i+1][j+1]);
                matrix[i][j] +=  minSum;
            }
        }
      
        int ans = matrix[0][0];
        for(int j = 1; j < n; j++) {
            ans = Math.min(ans, matrix[0][j]);
        }
        return ans;
    }
    
    
}