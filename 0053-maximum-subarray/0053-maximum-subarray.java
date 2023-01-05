class Solution {
    
    public int maxSubArray(int[] nums) {
        int best=Integer.MIN_VALUE;
        int current=0;
        
        for(int i=0; i<nums.length; i++){
            current=Math.max(nums[i], current + nums[i]);
            best=Math.max(current, best);
        }
        return Math.max(best, current);
    }
}