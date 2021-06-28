class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack();
        
        for(int asteroid: asteroids) {
            if(stack.isEmpty() || stack.peek() < 0 || stack.peek() > 0 && asteroid > 0) {
                stack.push(asteroid);
            }
            else {
                // current asteroid is smaller than previous asteroid
                if(Math.abs(asteroid) < Math.abs(stack.peek())) {
                    continue;
                }
                
                // destroy asteroids with smaller magnitudes coming towards current asteroid
                while(!stack.isEmpty() && Math.abs(asteroid) > Math.abs(stack.peek()) && stack.peek() > 0) {
                    stack.pop();
                }
                
                // destroy both asteroids if coming asteroid is equal in maginute
                if(!stack.isEmpty() && Math.abs(asteroid) == Math.abs(stack.peek()) && stack.peek() > 0) {
                    stack.pop();
                }
                else if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
            // System.out.println(stack);
        }
        
        int[] ans = new int[stack.size()];
        
        for(int i = ans.length-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}