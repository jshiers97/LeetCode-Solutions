class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack=new Stack<>(); 
        int max=0; 
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