class Solution {
    long mod=1000000007;
   
    public int numWays(int steps, int arrLen) {
        int min=Math.min(steps, arrLen);
        long[][] dp=new long[steps+1][min+1];
        for(long[] arr: dp){
            Arrays.fill(arr, -1); 
        }
        
        return (int)recurse(steps, 0, min, 0, dp);
        
    }
    public long recurse(int steps, int step, int arrLen, int index, long[][] dp){
        if(step==steps){
            if(index==0){
                return 1;
            }
            return 0;
        }
        
        if(dp[step][index]!=-1){
            return dp[step][index];
        }
        
        long left=0;
        if(index>0){
            left=recurse(steps, step+1, arrLen, index-1, dp);
        }
        long right=0;
        if(index < arrLen-1){
            right=recurse(steps, step+1, arrLen, index+1, dp); 
        }
        long stay=recurse(steps, step+1, arrLen, index, dp); 
        dp[step][index]=(left+right+stay)%mod; 
        return dp[step][index];
    }
}