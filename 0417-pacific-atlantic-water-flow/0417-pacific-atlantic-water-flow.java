class Solution {
    int m;
    int n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       this.heights=heights;
        List<List<Integer>> output=new ArrayList<>();
        this.m=heights.length;
        this.n=heights[0].length;
        boolean[][] Atlantic=new boolean[m][n];
        boolean[][] Pacific=new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(i, 0, Pacific, -1);
            dfs(i, n-1, Atlantic, -1);
        }
        for(int i=0; i<n; i++){
            dfs(0, i, Pacific, -1);
            dfs(m-1, i, Atlantic, -1);
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(Atlantic[i][j] && Pacific[i][j]){
                    List<Integer> insert=new ArrayList<>();
                    insert.add(i);
                    insert.add(j);
                    output.add(insert);
                }
            }
        }
        return output; 
        
        
        
    }
    
    public void dfs(int i, int j, boolean[][] seen, int prevValue){
        if(i>=m || i<0 || j>=n || j<0 || heights[i][j]<prevValue || seen[i][j]){
            return;
        }
        seen[i][j]=true;
        dfs(i+1, j, seen, heights[i][j]);
        dfs(i-1, j, seen, heights[i][j]);
        dfs(i, j+1, seen, heights[i][j]);
        dfs(i, j-1, seen, heights[i][j]);
        return;
    }
}