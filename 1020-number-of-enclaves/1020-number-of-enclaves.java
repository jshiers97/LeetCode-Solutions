class Solution {
    public int numEnclaves(int[][] grid) {
        int closed=0; 
        int[][] DIRECTIONS=new int[][]{ {0,1}, {1, 0}, {-1, 0}, {0, -1}};
        int total=0;
        int m=grid.length;
        int n=grid[0].length;
        //boolean[][] seen=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 ){
                    int currNodes=0;
                    boolean walkOff=false;
                    Queue<int[]> q=new LinkedList<>(); 
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] curr=q.poll(); 
                        int r=curr[0];
                        int c=curr[1];
                        grid[r][c]=-1; 
                        currNodes++;
                        if(r==0 || r==m-1 || c==0 || c==n-1){
                            walkOff=true;
                        }
                        for(int[] dir: DIRECTIONS){
                            int x=r+dir[0];
                            int y=c+dir[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                                grid[x][y]=-1;
                                q.offer(new int[]{x, y});
                                
                            }
                        }
                    }
                    if(!walkOff){
                        total+=currNodes;
                    }
                }
            }
        }
        return total; 
    }
}