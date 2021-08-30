class MinStack {
    Stack<int[]> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new int[]{x, x});
        }
        else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[0];
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */