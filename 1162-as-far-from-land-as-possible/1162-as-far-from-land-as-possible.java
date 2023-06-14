class Solution {
    public int maxDistance(int[][] grid) {
        int max=-1;
        int m=grid.length;
        int n=grid[0].length;
        int[][] DIRECTIONS=new int[][]{ {0,1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    grid[i][j]=-1;
                    q.offer(new int[]{i, j});
                }
               
            }
        }
        
        while(!q.isEmpty()){
            int[] curr=q.poll(); 
            int x=curr[0];
            int y=curr[1];
            int dist; 
            if(grid[x][y]==-1){
                dist=1;
            }
            else{
                dist=grid[x][y]+1;
            }
            for(int[] dir: DIRECTIONS){
                int r=x+dir[0];
                int c=y+dir[1];
                if(r<0 || r>= m || c<0 || c>=n || grid[r][c]==-1){
                    continue; 
                }
                if(grid[r][c]==0){
                    grid[r][c]=dist;
                    max=Math.max(max, dist);
                    q.offer(new int[]{r, c});
                }
                else if(grid[r][c] > dist){
                    
                    grid[r][c]=dist;
                    q.offer(new int[]{r, c});
                    max=Math.max(max, dist);
                }
                
            }
        }
       
        
        
        
        return max; 
    }
}