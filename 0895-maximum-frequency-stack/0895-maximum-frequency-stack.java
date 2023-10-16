class FreqStack {

    Map<Integer, Integer> count=new HashMap<>(); 
    Map<Integer, Stack<Integer>> level=new HashMap<>(); 
    int maxVal=-1;
    int maxCount=0;
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        if(!count.containsKey(val)){
            count.put(val, 1); 
            if(level.size() ==0){
                level.put(1, new Stack<>()); 
                
            }
            level.get(1).push(val); 
            
        }
        else{
            count.put(val, count.get(val)+1);
            if(level.size() < count.get(val)){
                level.put(count.get(val), new Stack<>()); 
            }
            level.get(count.get(val)).push(val); 
        }
        
        if(count.get(val) >= maxCount){
            maxCount=count.get(val);
            maxVal=val;
        }
    }
    
    public int pop() {
        System.out.println("here" + maxVal); 
        int ret=maxVal; 
        count.put(maxVal, count.get(maxVal)-1);
        level.get(maxCount).pop();
        if(level.get(maxCount).size()!=0){
            maxVal=level.get(maxCount).peek();
        }
        else{
            maxCount--;
            if(maxCount>=1){
                maxVal=level.get(maxCount).peek();
            }
            
        }
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */