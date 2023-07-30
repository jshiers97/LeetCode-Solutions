class Solution {
    Integer[][] combos=new Integer[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                                        {},{1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    public int knightDialer(int n) {
        int[][] memo=new int[n+1][10];
        for(int i=0; i<=9; i++){
            memo[1][i]=1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int neighbor: combos[j]){
                    memo[i][j]+=memo[i-1][neighbor];
                    memo[i][j]%=1000000007;
                }
            }
        }
        int answer=0;
        for(int i=0; i<10; i++){
            answer+= memo[n][i];
            answer%=1000000007;
        }
        return answer;
    }
}