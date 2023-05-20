class Solution {
    int[][] DIRECTIONS=new int[][]{ {0,1},{1, 0}, {-1, 0}, {0,-1}};
    int m;
    int n; 
    public void solve(char[][] board) {
        this.m=board.length;
        this.n=board[0].length;
        
        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                changeE(board, 0, j); 
            }
        }
        for(int j=0; j<n; j++){
            if(board[m-1][j]=='O'){
                changeE(board, m-1, j); 

            }
        }
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                changeE(board, i, 0); 
            }
        }
        for(int i=0; i<m; i++){
            if(board[i][n-1]=='O'){
                changeE(board, i, n-1); 
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    change(board, i, j); 
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='E'){
                    board[i][j]='O';
                }
            }
        }
       
    }
    public void change(char[][] board, int i, int j){
        LinkedList<int[]> q=new LinkedList<>(); 
        board[i][j]='X';
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            
            for(int[] dir: DIRECTIONS){
                int x=r+dir[0];
                int y=c+dir[1];
                if(x< 0 || y < 0 || x==m || y==n || board[x][y]!='O'){
                    continue;
                }  
                    board[x][y]='X';
                    q.offer(new int[]{x, y});

            }
        }

    }
    public void changeE(char[][] board, int i, int j){
        LinkedList<int[]> q=new LinkedList<>(); 
        board[i][j]='E';
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            
            for(int[] dir: DIRECTIONS){
                int x=r+dir[0];
                int y=c+dir[1];
                if(x< 0 || y < 0 || x==m || y==n || board[x][y]!='O'){
                    continue;
                }  
                board[x][y]='E';
                q.offer(new int[]{x, y});

            }
        }

    }
}