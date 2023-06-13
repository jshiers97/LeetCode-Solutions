class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows=new HashMap<>(); 
        //Set<String> rows=new HashSet<>();
        Set<String> seen=new HashSet<>(); 
        for(int i=0; i<grid.length; i++){
            StringBuilder str=new StringBuilder();
            for(int j=0; j<grid[0].length; j++){
                str.append(grid[i][j]);
                str.append("$");
            }
            //System.out.println(str.toString()); 
            if(!rows.containsKey(str.toString())){
                rows.put(str.toString(), 0); 
            }
            rows.put(str.toString(), rows.get(str.toString())+1);
        }
        int pairs=0;
        for(int i=0; i<grid[0].length; i++){
            StringBuilder str=new StringBuilder();
            for(int j=0; j<grid.length; j++){
                str.append(grid[j][i]);
                str.append("$");
            }
            //System.out.println(str.toString()); 
            if(rows.containsKey(str.toString()) ){
                pairs+= rows.get(str.toString());
            }
        }
        return pairs; 
    }
}