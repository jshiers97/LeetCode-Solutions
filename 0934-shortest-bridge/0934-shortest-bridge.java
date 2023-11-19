class Solution {
    int m;
    int n;
    Set<int[]> seen=new HashSet<>(); 
    Queue<int[]> q1=new LinkedList<>(); 
    int[][] DIRECTIONS=new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
    public int shortestBridge(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    flip(grid, i, j); 
                    j=n;
                    i=m;
                }
            }
        }
        
        
        q1.offer(new int[]{-1,-1}); 
        int time=0; 
        while(!q1.isEmpty()){
            int[] curr=q1.poll(); 
            if(curr[0]==-1){
                if(q1.isEmpty()){
                    break;
                }
                q1.offer(new int[]{-1,-1});
                time++; 
            }
            else{
                for(int[] dir: DIRECTIONS){
                    int r=curr[0]+dir[0];
                    int c=curr[1] + dir[1];
                    if(r>= m || r < 0 || c >= n || c < 0 || grid[r][c]==-1){
                        continue;
                    }
                    else{
                        if(grid[r][c]==1){
                            return time; 
                        }
                        else{
                            grid[r][c]=-1; 
                            q1.offer(new int[]{r, c});
                        }
                    }
                }
            }
        }
        return time; 
        
        
    }
    public void flip(int[][] grid, int i, int j){
        Queue<int[]> q=new LinkedList<>(); 
        q.offer(new int[]{i, j});
        q1.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr=q.poll(); 
            int r=curr[0];
            int c=curr[1];
            grid[r][c]=-1; 
            for(int[] dir: DIRECTIONS){
                int x=r+dir[0];
                int y=c+dir[1];
                if(x<0 || x >= m || y<0 || y>=n || grid[x][y]!=1){
                    continue;
                }
                else{
                    grid[x][y]=-1; 
                    q.offer(new int[]{x, y});
                    q1.offer(new int[]{x, y});
                }
            }
        }
    }
}