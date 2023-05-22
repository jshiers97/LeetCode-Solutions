class Solution {
    int count=0; 
    int target;
    int[] nums; 
    int[][] dp;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        this.target=target;
        this.nums=nums; 
        this.total=Arrays.stream(nums).sum();
        this.dp=new int[nums.length][total*2 + 1];
        
        return recurse(0, 0); 
        
    }
    public int recurse(int index, int sum){
        if(index==nums.length){
            if(target==sum){
                return 1;
            }
            return 0; 
        }
        if(dp[index][sum + total]!=0){
            return dp[index][sum+total];
        }
        int add=recurse(index+1, sum+nums[index]);
        int sub=recurse(index+1, sum-nums[index]);
        dp[index][sum+total]=add + sub; 
        return dp[index][sum+total]; 
        
    }
}