class Solution {
    int[] dp;
    int[] nums;
    public int rob(int[] nums) {
        this.dp=new int[nums.length];
        Arrays.fill(dp, -1); 
        if(nums.length ==1){
            return nums[0];
        }
        this.nums=nums;
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            int take=dp[i-1];
            int skip=dp[i-2] + nums[i];
            dp[i]=Math.max(take, skip); 
        }
        
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
    
}