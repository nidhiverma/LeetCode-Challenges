/*
    @author: Nidhi
    
    Approach1: 
        Copy top edge to an array and then 
        move the left to top
        move bottom to left
        move right to bottom
        move top to right
        
        Time Complexity: O(n^2)
        
    Approach 2:
        Tim
        Space Complexity: O(1)
        
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            
            for(int i = first; i < last; i++) {
                int offset = i-first;
                
                // save top
                int top = matrix[first][i];
                
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                
                // top -> right
                matrix[i][last] = top;
            }
        }
    }
}