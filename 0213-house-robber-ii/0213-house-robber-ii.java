class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1=new int[nums.length-1];
        int[] dp2=new int[nums.length-1];
        int[] nums1=new int[nums.length-1];
        int[] nums2=new int[nums.length-1];
        for(int i=0; i<nums.length-1; i++){
            nums1[i]=nums[i];
        }
        for(int i=1; i<nums.length; i++){
            nums2[i-1]=nums[i];
        }
        dp1[0]=nums[0];
        dp1[1]=nums[1];
        dp2[0]=nums[1];
        dp2[1]=nums[2];
        int max1=rob1(nums1, dp1);
        
        int max2=rob1(nums2, dp2);
        return Math.max(max1, max2); 
    }
    
    
    public int rob1(int[] nums, int[] dp) {
        
        
        if(nums.length ==1){
            return nums[0];
        }
        
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