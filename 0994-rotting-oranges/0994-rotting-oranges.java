class Solution {
    int[][] DIRECTIONS=new int[][]{{1,0},{-1, 0}, {0, 1}, {0, -1}}; 
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]>q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int oranges=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j]==1){
                    oranges++;
                }
            }
        }
        q.offer(new int[]{-1, -1}); 
        int count=0;
        while(!q.isEmpty()){
            int curr[]=q.poll(); 
            int x=curr[0];
            int y=curr[1];
            if(x==-1){
                if(!q.isEmpty()){
                    q.offer(new int[]{-1, -1});
                    count++; 
                }
                
            }
            for(int[] dir: DIRECTIONS){
                int r=x+dir[0];
                int c=y+dir[1];
                if(r< 0 || c < 0 || r==m || c==n || grid[r][c]!=1){
                    continue; 
                }
                grid[r][c]=2;
                oranges--; 
                q.offer(new int[]{r, c});
            }
        }
        if(oranges>0){
            return -1; 
        }
        System.out.println(oranges);
        return count; 
    }
}