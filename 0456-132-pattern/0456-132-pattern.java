class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min=new int[nums.length];
        int minVal=nums[0];
        for(int i=0; i<nums.length; i++){
            minVal=Math.min(nums[i], minVal);
            min[i]=minVal;
        }
        Stack<Integer> stack=new Stack<>(); 
        for(int i=nums.length-1; i>=0; i--){
            int curr=nums[i];
            if(curr > min[i]){
                if(stack.isEmpty()){
                    stack.push(curr); 
                }
                else if(stack.peek() <= min[i]){
                    while(!stack.isEmpty() && stack.peek() <= min[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek() > min[i] && curr > stack.peek()){
                        return true; 
                    }
                    
                }
                else if(stack.peek() > min[i] && curr > stack.peek()){
                    return true; 
                }
                else{
                    stack.push(curr);
                }
            }
        }
        return false;
    }
}