class Solution {
    public int[][] candyCrush(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean toCont=false;
        //Check horizontal
        for(int i=0; i<m; i++){
            for(int j=0; j+2<n;j++){
                
                int val=Math.abs(board[i][j]);
                if(val==0){
                    continue;
                }
                if(val==Math.abs(board[i][j+1]) && val == Math.abs(board[i][j+2])){
                    board[i][j+1]=-val;
                    board[i][j+2]=-val;
                    board[i][j]=-val;
                    toCont=true;
                }
            }
        }
        
        //Check vertical
        for(int i=0; i+2<m; i++){
            for(int j=0; j<n;j++){
                int val=Math.abs(board[i][j]);
                if(val==0){
                    continue;
                }
                if(val==Math.abs(board[i+1][j]) && val == Math.abs(board[i+2][j])){
                    board[i+1][j]=-val;
                    board[i+2][j]=-val;
                    board[i][j]=-val;
                    toCont=true;
                }
            }
        }
        
        //turn to zeroes
       /* for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                int val=board[i][j];
                if(val < 0){
                    board[i][j]=0;
                }
            }
        }
        
        //fall
        for(int i=0; i+1<m; i++){
            for(int j=0; j<n; j++){
                int val=board[i][j];
                if(val >0 && board[i+1][j]==0){
                    int r=i+1;
                    while(r<m && board[r][j]==0){
                        r++;
                        
                    }
                    board[r-1][j]=val;
                    board[i][j]=0;
                }
            }
        }*/
        
        for (int c = 0; c < n; ++c) {
            int wr = m - 1;
            for (int r = m-1; r >= 0; --r)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            while (wr >= 0)
                board[wr--][c] = 0;
        }
        return toCont ? candyCrush(board) : board;
        
        
        
    }
}