class Solution {
        // Time Complexity : O(N) + O(N)   --> heights traversal + stack maintain
        // Space Complexity: O(N)
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack();
            int maxArea = 0, n = heights.length;
            
            
            for(int i = 0; i <= n; i++) {
                while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                    int height = heights[stack.peek()];
                    stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek()-1;
                    
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }
    
//     public int largestRectangleArea(int[] heights) {
//         int[] nsl = nextSmallerLeft(heights);
//         int[] nsr = nextSmallerRight(heights);
        
//         // System.out.println(Arrays.toString(nsr));
//         // System.out.println(Arrays.toString(nsl));
        
//         int maxArea = 0;
        
//         for(int i = 0; i < heights.length; i++) {
//             int area = (nsr[i] - nsl[i] -1) * heights[i];
//             if(maxArea < area) maxArea = area; 
//         }
//         return maxArea;
//     }
    
//     public int[] nextSmallerLeft(int[] heights) {
//         Stack<Integer> stack = new Stack();
//         int[] nsl = new int[heights.length];
        
//         for(int i = 0; i < heights.length; i++) {
//            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            } 
//            if(stack.isEmpty()) {
//                nsl[i] = -1;
//            } 
//            else {
//                nsl[i] = stack.peek();
//            }
//             stack.push(i);
//         }
//         return nsl;
//     }
    
//     public int[] nextSmallerRight(int[] heights) {
//         Stack<Integer> stack = new Stack();
//         int[] nsr = new int[heights.length];
        
//         for(int i = heights.length-1; i >= 0; i--) {
//            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            } 
//            if(stack.isEmpty()) {
//                nsr[i] = heights.length;
//            } 
//            else {
//                nsr[i] = stack.peek();
//            }
//             stack.push(i);
//         }
//         return nsr;
//     }
} 