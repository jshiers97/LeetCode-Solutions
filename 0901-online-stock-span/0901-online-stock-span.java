class StockSpanner {

    Stack<int[]> stack=new Stack<>();
    int day=1; 
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new int[]{price, day});
            day++;
            return 1;
        }
        else if(stack.peek()[0] > price){
            stack.push(new int[]{price, day});
            day++;
            return 1;
        }
        else{
            int curr=1;
            while(!stack.isEmpty() && stack.peek()[0] <= price){
                
                stack.pop(); 
            }
            if(!stack.isEmpty()){
                curr=day-stack.peek()[1];
            }
            else{
                curr=day;
            }
            stack.push(new int[]{price, day});
            day++;
            return curr; 
        }
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */