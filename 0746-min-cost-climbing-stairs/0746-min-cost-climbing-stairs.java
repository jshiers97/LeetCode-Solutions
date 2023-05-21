class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0]=0;
        dp[1]=0;
        recurse(dp, cost, cost.length);
       
        return dp[cost.length];
    }
    public int recurse(int[] dp, int[] cost, int index){
        
        if(dp[index] !=Integer.MAX_VALUE ){
            return dp[index]; 
        }
        int oneStep=recurse(dp, cost, index-1) + cost[index-1];
        int twoStep=recurse(dp, cost, index-2) + cost[index-2];
        dp[index]=Math.min(oneStep, twoStep); 
        return dp[index];
    }
}