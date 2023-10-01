class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0; 
        int right=0; 
        int min=Integer.MAX_VALUE;
        int curr=0; 
        
        for(int i=0; i<nums.length; i++){
            curr+=nums[i];
            while(curr>= target){
                min=Math.min(min, i-left+1);
                curr-=nums[left++];
                
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
        
    }
}