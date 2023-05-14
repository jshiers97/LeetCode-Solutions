class Solution {
    int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {-1, 0}, {0,-1}, {1,-1} , {-1, 1} , {1,1}, {-1,-1}};
    char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.board=board;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        int mines = getMines(board, click[0], click[1]);
        if (mines != 0) {
            board[click[0]][click[1]] = (char) (mines + '0');
            return board;
        }
        board[click[0]][click[1]] = 'B';
        LinkedList<int[]> q=new LinkedList<>(); 
        q.offer(click);
        while(!q.isEmpty()){
            
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            
            
            
            
                
                for(int[] dir: DIRECTIONS){
                    int r=dir[0]+x;
                    int c=dir[1]+y;
                    if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]=='E'){
                        mines=getMines(board, r, c); 
                        
                        if(mines==0){
                            board[r][c]='B';
                            q.offer(new int[]{r, c});
                        }
                        else{
                    
                            board[r][c]=(char)(mines+'0');
                        }
                        
                    }
                }
                
                
            
        }
        return board;
    }
    public int getMines(char[][] board, int r, int c){
        int count=0;
        for(int[] dir: DIRECTIONS){
            int x=r+dir[0];
            int y=c+dir[1];
            if(x>=0 && x<board.length && y>=0 && y<board[0].length){
                if(board[x][y]=='M'){
                    count++;
                }
               
            }
        }
        return count;
    }
}