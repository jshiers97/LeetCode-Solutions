class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(dst==src){
            return 0;
        }
        
        int[] prev=new int[n];
        int[] curr=new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE); 
        prev[src]=0;
        
        for(int i=1; i<k+2; i++){
            for(int[] flight: flights){
                int from=flight[0];
                int to=flight[1];
                int cost=flight[2];
                
                if(prev[from]< Integer.MAX_VALUE){
                    int temp=prev[from] + cost; 
                    curr[to]=Math.min(curr[to], temp); 
                }
            }
            prev=curr.clone(); 
        }
        return curr[dst]==Integer.MAX_VALUE ? -1 : curr[dst];
        
        
    }
}