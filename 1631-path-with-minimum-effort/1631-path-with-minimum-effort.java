class Solution {
    int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}};
    int[][] heights; 
    int[][] costs;
    int m;
    int n;
    
    class Cell{
        int x;
        int y; 
        int cost; 
        public Cell(int x, int y, int cost){
            this.x=x;
            this.y=y; 
            this.cost=cost; 
        }
    }
    public int minimumEffortPath(int[][] heights) {
        this.heights=heights;
        this.m=heights.length;
        this.n=heights[0].length; 
        this.costs=new int[m][n];
        for(int[] arr: costs){
            Arrays.fill(arr, Integer.MAX_VALUE); 
        }
        costs[0][0]=0;
        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;
        PriorityQueue<Cell> pq=new PriorityQueue<>( (x,y ) -> x.cost-y.cost); 
        pq.offer(new Cell(0, 0, 0)); 
        while(!pq.isEmpty()){
            Cell curr=pq.poll(); 
            int r=curr.x;
            int c=curr.y; 
            visited[r][c]=true; 
            if(r==m-1 && c==n-1){
                return curr.cost; 
            }
            for(int[] dir: DIRECTIONS){
                int R=r+dir[0];
                int C=c+dir[1];
                if(R >=m || R < 0 || C>=n || C < 0 || visited[R][C]){
                    continue;
                }
                else{
                    int temp= Math.max( curr.cost, Math.abs(heights[r][c] - heights[R][C]));
                    if(costs[R][C] > temp){
                        costs[R][C]=temp; 
                        pq.offer(new Cell(R, C, temp)); 
                    }
                    
                }
            }
            
        }
        return costs[m-1][n-1];
        
    }
    public void dfs(int r, int c, boolean[][] visited){
        System.out.println(r + " " + c);
        int curr=heights[r][c];
        for(int[] dir: DIRECTIONS){
            int x=r+dir[0];
            int y=c+dir[1];
            
            if(x>=m || x<0 || y>=n || y<0 || visited[x][y]==true ){
                continue;
            }
            else{
                int replace=Math.max(costs[r][c], Math.abs(curr-heights[x][y]));
                if(costs[x][y] <= replace){
                    continue;
                }
                else{
                    costs[x][y]=replace; 
                    visited[x][y]=true; 
                    dfs(x, y, visited); 
                    visited[x][y]=false;
                }
                
            }
        }
    }
}