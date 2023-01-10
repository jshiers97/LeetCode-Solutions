class Solution {
    public int countBattleships(char[][] board) {
        int battleships=0;
        int m=board.length; 
        int n=board[0].length;
        int[][] DIRECTIONS=new int[][]{ {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
                    battleships++;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] curr=q.poll();
                        for(int[] dir: DIRECTIONS){
                            int x=curr[0] + dir[0];
                            int y= curr[1] + dir[1];
                            if(x<m && x>=0 && y<n && y>=0 && board[x][y]=='X'){
                                board[x][y]='.';
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return battleships;
    }
}