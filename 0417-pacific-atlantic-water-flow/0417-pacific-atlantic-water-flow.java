class Solution {
    List<List<Integer>> output=new ArrayList<>(); 
    int[][] DIRECTIONS=new int[][]{ {0, 1}, {1,0}, {-1, 0}, {0, -1}};
    int m; 
    int n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m=heights.length;
        this.n=heights[0].length;
        this.heights=heights;
       boolean[][] Atlantic=new boolean[m][n];
        boolean[][] Pacific = new boolean[m][n];
        Queue<int[]> q=new LinkedList<>(); //Pacific 
        Queue<int[]> q2=new LinkedList<>();
        for(int i=0; i<m; i++){
            Pacific[i][0]=true;
            q.offer(new int[]{i, 0});
            Atlantic[i][n-1]=true;
            q2.offer(new int[]{i, n-1});
        }
        for(int i=0; i<n; i++){
            Pacific[0][i]=true;
            q.offer(new int[]{0, i});
            Atlantic[m-1][i]=true;
            q2.offer(new int[]{m-1, i});
        }
        //boolean[][] temp=bfs(q);
        //boolean[][] temp2=bfs(q2);
        boolean [][] visited=new boolean[m][n];
        for(boolean[] row: visited){
            Arrays.fill(row, false); 
        }
        while(!q.isEmpty()){
            int[] curr=q.poll(); 
            int x=curr[0];
            int y=curr[1];
            visited[x][y]=true;
            Pacific[x][y]=true;
            for(int[] dir: DIRECTIONS){
                int r=x+dir[0];
                int c=y+dir[1];
                if(r < 0 || r >= m || c < 0 || c>=n || visited[r][c] ){
                    continue;
                }
                else if(heights[r][c] < heights[x][y]){
                    continue;
                }
                else{
                    q.offer(new int[]{r, c});
                    
                }
            }
            
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.println(i +" and " + j + "  is " + Atlantic[i][j]);
            }
        }
        visited=new boolean[m][n];
        for(boolean[] row: visited){
            Arrays.fill(row, false); 
        }
        while(!q2.isEmpty()){
            int[] curr=q2.poll(); 
            int x=curr[0];
            int y=curr[1];
            visited[x][y]=true;
            Atlantic[x][y]=true;
            for(int[] dir: DIRECTIONS){
                int r=x+dir[0];
                int c=y+dir[1];
                if(r < 0 || r >= m || c < 0 || c>=n || visited[r][c] ){
                    continue;
                }
                else if(heights[r][c] < heights[x][y]){
                    continue;
                }
                else{
                    q2.offer(new int[]{r, c});
                    
                }
            }
            
        }
      
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(Pacific[i][j] && Atlantic[i][j]){
                    List<Integer> insert=new ArrayList<>();
                    insert.add(i);
                    insert.add(j);
                    output.add(insert);
                }
            }
        }
        return output; 
        
        
        
    }
    // private boolean[][] bfs(Queue<int[]> queue) {
    //     boolean[][] reachable = new boolean[m][n];
    //     while (!queue.isEmpty()) {
    //         int[] cell = queue.poll();
    //         // This cell is reachable, so mark it
    //         reachable[cell[0]][cell[1]] = true;
    //         for (int[] dir : DIRECTIONS) { // Check all 4 directions
    //             int newRow = cell[0] + dir[0];
    //             int newCol = cell[1] + dir[1];
    //             // Check if new cell is within bounds
    //             if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
    //                 continue;
    //             }
    //             // Check that the new cell hasn't already been visited
    //             if (reachable[newRow][newCol]) {
    //                 continue;
    //             }
    //             // Check that the new cell has a higher or equal height,
    //             // So that water can flow from the new cell to the old cell
    //             if (heights[newRow][newCol] < heights[cell[0]][cell[1]]) {
    //                 continue;
    //             }
    //             // If we've gotten this far, that means the new cell is reachable
    //             queue.offer(new int[]{newRow, newCol});
    //         }
    //     }
    //     return reachable;
    // }
}