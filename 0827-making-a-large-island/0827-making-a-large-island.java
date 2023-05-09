class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map=new HashMap<>(); 
        int[][] DIRECTIONS=new int[][]{ {0,1 }, {1, 0}, {0, -1}, {-1, 0}}; 
        int island=2; 
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int size=1;
                    grid[i][j]=island; 
                    while(!q.isEmpty()){
                        int[] curr=q.poll(); 
                        int x=curr[0];
                        int y=curr[1];
                        
                        
                        for(int[] dir: DIRECTIONS){
                            int r=x + dir[0];
                            int c=y + dir[1];
                            if(r >=0 && r < m && c>=0 && c< n && grid[r][c]==1){
                                q.offer(new int[]{r, c});
                                grid[r][c]=island;
                                size++; 
                            }
                        }
                    }
                    map.put(island, size);
                    //System.out.println(size); 
                    island++; 
                    
                }
            }
        }
        int max=0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    //System.out.println("i is and j is " + i + " " + j);
                    Set<Integer> seen=new HashSet<>();
                    int left=0;
                    if(j-1 >=0){
                        left=map.getOrDefault(grid[i][j-1], 0);
                        seen.add(grid[i][j-1]);
                    }
                    int right=0; 
                    if(j+1 < n && !seen.contains(grid[i][j+1])){
                        right=map.getOrDefault(grid[i][j+1], 0);
                        seen.add(grid[i][j+1]);
                    }
                    int up=0; 
                    if(i-1 >=0 && !seen.contains(grid[i-1][j])){
                        up=map.getOrDefault(grid[i-1][j], 0);
                        seen.add(grid[i-1][j]);
                    }
                    int down=0; 
                    if(i+1 < m && !seen.contains(grid[i+1][j])){
                        down=map.getOrDefault(grid[i+1][j], 0);
                        seen.add(grid[i+1][j]);
                    }
                    
                    //System.out.println(up); 
                        
                    
                    max=Math.max(max, left+right+up+down+1);
                    
                    
                }
            }
        }
        if(max==0){
            return map.get(2);
        }
        return max;
    }
}