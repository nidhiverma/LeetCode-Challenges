/*
    @author: Nidhi
    
    Approach: 
        Start searching from bottom-left cell of the matrix
        move right if curr value < target
        move up if curr value  > target
        return true if target found
        
        return false if search space is exhausted
        
    Time Complexity: O(m+n)
    Space Complexity: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1, j = 0;
        
        while(i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
        }
        return false;
    }
}