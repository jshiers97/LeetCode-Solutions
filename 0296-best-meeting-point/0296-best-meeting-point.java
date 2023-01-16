class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> cols=new ArrayList<>();
        List<Integer> rows=new ArrayList<>();
        int size=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    cols.add(j);
                    rows.add(i);
                    size++;
                }
            }
            
        }
        Collections.sort(cols);
        int distance=0;
        int[] spot=new int[2];
        spot[0]=rows.get(size/2);
        spot[1]=cols.get(size/2);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    distance+= calculate(i, j, spot);
                }
            }
        }
        return distance;
        
    }
    public int calculate(int i, int j, int[] spot){
        int x= Math.abs(i-spot[0]);
        int y=Math.abs(j-spot[1]);
        return x+y;
    }
}