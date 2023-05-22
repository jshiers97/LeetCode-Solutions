class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(i > max){
                return false;
            }
            int jump=nums[i];
            max=Math.max(max, i + jump);
            if(max>=nums.length-1){
                return true; 
            }
            
        }
        return false; 
    }
}