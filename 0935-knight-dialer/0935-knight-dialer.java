class Solution {
    Integer[][] graph = new Integer[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                                        {},{1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    int MOD = (int)1e9 + 7;
    public int knightDialer(int N) {
        //dp[i][j] stores：when there are 'i' hops left and the current number is 'j', how many combination we have
        int[][] dp = new int[N + 1][10];
        //base case, defined by question as: 
        //when it has 1 hop left on the current number, it should just return 1 (dp[0][j] IS NOT CORRECT)
        for(int j = 0; j < 10; j++) dp[1][j] = 1;
        //iterate sub-problem
        //be careful. i start on 2 because 2 ~ N is N - 1, and i - 1 could get our basecase
        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int neighbor : graph[j]){//current number's neighbor
                    dp[i][j] += dp[i - 1][neighbor];
                    //MOD should be seperated because it may alter our state transfer when number gets big
                    dp[i][j] %= MOD; 
                } 
            
            }
        }
        int cnt = 0;
        for(int j = 0; j < 10;j++){
            cnt += dp[N][j];
            cnt %= MOD; //MOD should be seperated 
        }
        return cnt;
    }
}