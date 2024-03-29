class Solution {
    public int largestRectangleArea(int[] heights) {
         //Stack is height[i], i
        int max=0; 
        Stack<int[]> stack=new Stack<>(); 
        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty() || stack.peek()[0] <= heights[i]){
                stack.push(new int[]{heights[i], i});
                
            }
            else{
                int prev=0;
            
                while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                    int calc=(i-stack.peek()[1]) * stack.peek()[0];
                    max=Math.max(max, calc);
                    prev=stack.peek()[1];
                    stack.pop(); 
                }
                stack.push(new int[]{heights[i], prev});
            }
        }
        System.out.println(stack.size());
        if(!stack.isEmpty()){
            int end=heights.length;
            while(!stack.isEmpty() ){
                    int calc=(end-stack.peek()[1]) * stack.peek()[0];
                    max=Math.max(max, calc);
                    //prev=stack.peek()[1];
                    stack.pop(); 
                } 
        }
        return max;
        
    }
}