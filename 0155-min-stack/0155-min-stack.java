class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        this.stack=new Stack<int[]>(); 
    }
    
    public void push(int val) {
        int min=val;
        if(!stack.isEmpty()){
            min=Math.min(min, stack.peek()[1]);
        }
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */