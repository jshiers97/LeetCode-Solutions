class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0; 
        }
        int[] dp=new int[amount+1];
        Arrays.fill(dp, 100001);
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
            for(int coin: coins){
                if(coin==i){
                    dp[i]=1;
                    break; 
                }
                else if(i-coin >0 && dp[i-coin]!=1000001){
                    dp[i]=Math.min(dp[i], dp[i-coin] + 1); 
                }
            }
        }
        return dp[amount] == 100001? -1 : dp[amount];
    }
}