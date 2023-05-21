class Solution {
    int[] dp;
    
    public int climbStairs(int n) {
        if(n<=2){
            return n; 
        }
        this.dp=new int[n];
        dp[0]=1;
        dp[1]=2; 
        recurse(n-1);
        return dp[n-1];
        
    }
    public int recurse(int index){
        if(index<0){
            return 0; 
        }
        if(dp[index]>0){
            return dp[index];
        }
        int oneStep=recurse(index-1);
        int twoStep=recurse(index-2);
        dp[index]=oneStep + twoStep;
        return dp[index]; 
    }
}