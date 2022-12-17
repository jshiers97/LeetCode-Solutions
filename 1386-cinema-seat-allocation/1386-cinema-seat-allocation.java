class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, int[]> map=new HashMap<>();
        
        for(int i=0; i<reservedSeats.length; i++){
            int row=reservedSeats[i][0];
            int col=reservedSeats[i][1];
            //boolean[] curr=map.get(row);
            if(col==1 || col==10){
                continue;
            }
            int[] curr = map.getOrDefault(row, new int[3]);
            if(col>=2 && col <=3){
                curr[0]=1;
                
            }
            else if(col >=4 && col <=5){
                curr[1]=1;
                curr[0]=1;
            }
            else if(col>=6 && col<=7){
                curr[1]=1;
                curr[2]=1;
            }
            else{
                curr[2]=1;
            }
            map.put(row, curr);
            
        }
        int total = n * 2 - 2 * map.size();
        for(int[] curr: map.values()){
            
            if(curr[0]==0){
                total++;
            }
            if(curr[2]==0){
                total++;
            }
            if(curr[0]==1 && curr[2]==1 && curr[1]==0){
                total++;
            }
            
        }
        return total;
        
    }
}