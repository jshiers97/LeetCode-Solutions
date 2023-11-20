class Solution {
    int m;
    int n;
    int max=-1; 
    int[][] DIRECTIONS= new int[][]{ {0,1}, {1,0}, {-1,0}, {0,-1}};
    public int maxDistance(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        Queue<int[]> q=new LinkedList<>(); 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j});
                }
            }
        }
        q.offer(new int[]{-1,-1});
        int dist=0;
        while(!q.isEmpty()){
            //System.out.println(set.size()); 
            int[] curr=q.poll(); 
            if(curr[0]==-1){
                if(q.size() > 0){
                    q.offer(new int[]{-1,-1});
                    dist++;
                    max=Math.max(max, dist);
                }
            }
            else{
                for(int[] dir : DIRECTIONS){
                    int r=curr[0]+dir[0];
                    int c=curr[1] + dir[1];
                    int[] temp=new int[]{r,c};
                    if(r>=m || r < 0 || c>=n || c < 0 || grid[r][c]!=0){
                        continue;
                    }
                
                    else{
                        q.offer(new int[]{r,c});
                        grid[r][c]=1; 
                    }
                }
            }
        }
        
        return max;
        
    
    }
}