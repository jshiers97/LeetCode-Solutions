class Solution {
    int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}};
    int m; 
    int n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Queue<int[]> q=new LinkedList<>(); 
        int subIslands=0;
        this.m=grid1.length;
        this.n=grid1[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid2[i][j]==1){
                    
                    //System.out.println(i + " " + j);
                    
                    if(sub(grid1, grid2, i, j)){
                        //System.out.println("is sub");
                        subIslands++;
                    }
                }
            }
        }
        return subIslands;
    }
    public boolean sub(int[][] grid1, int[][] grid2, int i, int j){
//         boolean found=true;
//         if(grid1[i][j]==1 && grid2[i][j]==1){
//             grid1[i][j]=0;
//             grid2[i][j]=0;
//             found=true;
//         }
//         else{
//             grid1[i][j]=0;
//             grid2[i][j]=0;
//             found=false;
//         }
//         for(int[] dir: DIRECTIONS){
//             int x=i+dir[0];
//             int y=j+dir[1];
//             if(x<0 || x >= m || y < 0 || y>= n || grid2[x][y]!=1 ){
//                 continue;
//             }
//             else{
//                 found= found && sub(grid1, grid2, x, y); 
//             }
            
//         }
//         return found;
        boolean found=true;
        Queue<int[]> q=new LinkedList<>(); 
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            if(grid1[x][y]!=1){
                found=false;
            }
            //grid1[x][y]=0;
            grid2[x][y]=0;
            for(int[] dir: DIRECTIONS){
                int a=x+dir[0];
                int b=y+dir[1];
                if(a<0 || a >= m || b < 0 || b>= n || grid2[a][b]!=1 ){
                    continue;
                }
                else{
                    if(grid2[a][b]==1){
                        grid2[a][b]=0;
                        q.offer(new int[]{a, b});
                    }
                }
            }

        }
        return found;
    }
}