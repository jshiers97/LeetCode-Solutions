class CustomStack {
    
    class Node{
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    
    Map<Integer, Node> map;
    Stack<Node> stack;
    int max;
    public CustomStack(int maxSize) {
        this.max=maxSize;
        this.stack=new Stack<>();
        this.map=new HashMap<>();
    }
    
    public void push(int x) {
        if(stack.size()==max){
            return;
        }
        else{
            Node insert=new Node(x);
            stack.push(insert);
            map.put(stack.size()-1, insert );
        }
        return;
    }
    
    public int pop() {
        if(stack.size()==0){
            return -1;
        }
        else{
            map.remove(stack.size()-1);
            return stack.pop().val;
        }
        
        
    }
    
    public void increment(int k, int val) {
        int size=Math.min(k, stack.size());
        for(int i=0; i<size; i++){
            map.get(i).val+=val;

        }
        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */