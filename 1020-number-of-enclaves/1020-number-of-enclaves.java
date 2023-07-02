class Solution {
    
    public int numEnclaves(int[][] grid) {
        int number=0;
        int[][] DIRECTIONS=new int[][]{ {0, 1}, {1,0}, {0, -1}, {-1, 0}};
        int m=grid.length;
        int n=grid[0].length;
        //top row
        for(int i=0; i<n; i++){
            if(grid[0][i]==1){
                grid[0][i]=0;
                Queue<int[]> q=new LinkedList<>(); 
                q.offer(new int[]{0, i});
                while(!q.isEmpty()){
                    int[] curr=q.poll(); 
                    int r=curr[0];
                    int c=curr[1];
                    
                    for(int[] dir: DIRECTIONS){
                        int x=r+dir[0];
                        int y=c+dir[1];
                        if(x>=m || x<0 || y>=n || y<0 || grid[x][y]==0){
                            continue; 
                        }
                        grid[x][y]=0;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        //left col
        for(int i=0; i<m; i++){
            if(grid[i][0]==1){
                grid[i][0]=0;
                Queue<int[]> q=new LinkedList<>(); 
                q.offer(new int[]{i,0});
                while(!q.isEmpty()){
                    int[] curr=q.poll(); 
                    int r=curr[0];
                    int c=curr[1];
                    
                    for(int[] dir: DIRECTIONS){
                        int x=r+dir[0];
                        int y=c+dir[1];
                        if(x>=m || x<0 || y>=n || y<0 || grid[x][y]==0){
                            continue; 
                        }
                        grid[x][y]=0;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        //right col
        for(int i=0; i<m; i++){
            if(grid[i][n-1]==1){
                grid[i][n-1]=0;
                Queue<int[]> q=new LinkedList<>(); 
                q.offer(new int[]{i, n-1});
                while(!q.isEmpty()){
                    int[] curr=q.poll(); 
                    int r=curr[0];
                    int c=curr[1];
                    
                    for(int[] dir: DIRECTIONS){
                        int x=r+dir[0];
                        int y=c+dir[1];
                        if(x>=m || x<0 || y>=n || y<0 || grid[x][y]==0){
                            continue; 
                        }
                        grid[x][y]=0;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        //bottom row
        for(int i=0; i<n; i++){
            if(grid[m-1][i]==1){
                grid[m-1][i]=0;
                Queue<int[]> q=new LinkedList<>(); 
                q.offer(new int[]{m-1, i});
                while(!q.isEmpty()){
                    int[] curr=q.poll(); 
                    int r=curr[0];
                    int c=curr[1];
                    
                    for(int[] dir: DIRECTIONS){
                        int x=r+dir[0];
                        int y=c+dir[1];
                        if(x>=m || x<0 || y>=n || y<0 || grid[x][y]==0){
                            continue; 
                        }
                        grid[x][y]=0;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    number++; 
                }
            }
        }
        return number; 
        
        
    }
}