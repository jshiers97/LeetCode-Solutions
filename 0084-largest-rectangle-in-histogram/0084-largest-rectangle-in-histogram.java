class Solution {
    public int largestRectangleArea(int[] heights) {
        int largest=0;
        Stack<int[] > stack=new Stack<>();
        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty() || stack.peek()[0] <= heights[i]){
                stack.push(new int[]{heights[i],i});
            }
            else{
                int last=0;
                while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                    int calc=(i-stack.peek()[1]) * stack.peek()[0];
                    largest=Math.max(largest, calc); 
                    last=stack.peek()[1];
                    stack.pop(); 
                }
                stack.push(new int[]{heights[i], last});
            }
        }
        int last=heights.length;
        while(!stack.isEmpty() ){
            int calc=(last-stack.peek()[1]) * stack.peek()[0];
            largest=Math.max(largest, calc); 
            stack.pop(); 
        }
        return largest; 
    }
}