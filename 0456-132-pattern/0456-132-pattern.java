class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        
        Stack<Integer> stack=new Stack<>(); 
        int[] min=new int[nums.length];
        int minVal=nums[0];
        min[0]=minVal;
        for(int i=1; i<nums.length; i++){
            minVal=Math.min(minVal, nums[i]);
            min[i]=minVal; 
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > min[i]){
                while(!stack.isEmpty() && stack.peek() <= min[i]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i] && stack.peek() > min[i]){
                    return true;
                }
                stack.push(nums[i]); 
            }
            
        }
        return false;
        
    }
}