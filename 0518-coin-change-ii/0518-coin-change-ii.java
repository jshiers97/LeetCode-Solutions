class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        for(int i=0; i<coins.length; i++){
            coins[i]*=-1; 
        }
        Arrays.sort(coins); 
        for(int i=0; i<coins.length; i++){
            coins[i]*=-1; 
        }
        dp[0]=1;
        for(int coin: coins){
            for(int i=0; i<dp.length; i++){
                if(i-coin>=0){
                    dp[i]+=dp[i-coin];
                    
                }
            }
        }
        return dp[amount];
    }
}