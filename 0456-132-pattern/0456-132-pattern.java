class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>(); 
        int[] min=new int[nums.length];
        int minV=nums[0];
        min[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < minV){
                minV=nums[i];
            }
            min[i]=minV;
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > min[i]){
                while(!stack.isEmpty() && stack.peek() <= min[i]){
                    stack.pop(); 
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
            
        }
        return false;
        
    }
}