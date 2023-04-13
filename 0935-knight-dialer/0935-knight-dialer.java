class Solution {
    Integer[][] combos=new Integer[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                                        {},{1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    int MOD = (int)1e9 + 7;
    public int knightDialer(int n) {
        int[][] dp=new int[n+1][10];
        for(int j=0; j<10; j++){
            dp[1][j]=1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int neighbor: combos[j]){
                    dp[i][j]+=dp[i-1][neighbor];
                    dp[i][j] %=MOD;
                }
            }
        }
        int answer=0;
        for(int i=0; i<10; i++){
            answer+= dp[n][i];
            answer%=MOD;
        }
        return answer;
    }
}