class Solution {
    int m;
    int n;
    int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int oranges=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 ){
                    oranges++;
                }
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        q.offer(new int[]{-1,-1});
        int time=0; 
        while(!q.isEmpty()){
            int[] curr=q.poll();
            if(curr[0]==-1){
                if(!q.isEmpty()){
                    time++;
                    q.offer(new int[]{-1,-1});
                }
                
            }
            else{
                int r=curr[0];
                int c=curr[1];
                for(int[] dir: DIRECTIONS){
                    int x=r+dir[0];
                    int y=c+dir[1];
                    if(x>=m || x<0 || y>=n || y<0 || grid[x][y]!=1){
                        continue;
                    }
                    else{
                        grid[x][y]=2;
                        oranges--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        if(oranges>0){
            return -1;
        }
        return time;
        
    }
}