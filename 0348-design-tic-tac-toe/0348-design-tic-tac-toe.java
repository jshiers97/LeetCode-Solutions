class TicTacToe {

    char[][] board;
    int[] rows;
    int[] cols;
    int diagonal=0;
    int antiDiagonal=0;
    int n;
    
    
    public TicTacToe(int n) {
        this.board=new char[n][n];
        this.rows=new int[n];
        this.cols=new int[n];
        this.n=n;
        
        
    }
    
    public int move(int row, int col, int player) {
        if(player==1){
            board[row][col]='O';
            rows[row]--;
            if(rows[row]==-n){
                return 1;
            }
            cols[col]--;
            if(cols[col]==-n){
                return 1;
            }
            
            if(row-col==0){
                diagonal--;
                if(diagonal==-n){
                    return 1;
                }
            }
            if(row + col == n-1){
                antiDiagonal--;
                if(antiDiagonal==-n){
                    return 1;
                }
            }
            
            return 0;
            
            
        }
        else{
            board[row][col]='X';
            rows[row]++;
            if(rows[row]==n){
                return 2;
            }
            cols[col]++;
            if(cols[col]==n){
                return 2;
            }
            
            if(row-col==0){
                diagonal++;
                if(diagonal==n){
                    return 2;
                }
            }
            if(row + col == n-1){
                antiDiagonal++;
                if(antiDiagonal==n){
                    return 2;
                }
            }
            
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */