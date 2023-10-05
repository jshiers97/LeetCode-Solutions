class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack=new Stack<>();
        int[] res=new int[temperatures.length];
        res[temperatures.length-1]=0;
        stack.push(new int[]{temperatures[temperatures.length-1], temperatures.length-1});
        for(int i=temperatures.length-2; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(new int[]{temperatures[i], i});
                res[i]=0;
            }
            else if( stack.peek()[0] > temperatures[i]){
                res[i]=Math.abs(stack.peek()[1]-i);
                stack.push(new int[]{temperatures[i], i});
            }
            else{
                while(!stack.isEmpty() && stack.peek()[0] <= temperatures[i]){
                    stack.pop(); 
                }
                if(!stack.isEmpty()){
                    res[i]=Math.abs(stack.peek()[1]-i);
                }
                else{
                    res[i]=0;
                }
                stack.push(new int[]{temperatures[i], i});
            }
            
        }
        return res;
        
    }
}