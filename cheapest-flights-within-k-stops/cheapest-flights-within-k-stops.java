class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        
        
        int[] prev=new int[n];
        int[] next=new int[n];
        for(int i=0; i<n; i++){
            prev[i]=Integer.MAX_VALUE;
            next[i]=Integer.MAX_VALUE;
        }
        prev[src]=0;
        
        for(int i=0; i<=k; i++){
            next[src]=0;
            for(int[] flight: flights){
                int sorc=flight[0];
                int dest=flight[1];
                int cost=flight[2];
                if(prev[sorc]==Integer.MAX_VALUE){
                    continue;
                }
                //System.out.println(dest); 
                next[dest]=Math.min(next[dest], prev[sorc] + cost);
            }
            prev=next.clone();
        }
      
        return prev[dst]==Integer.MAX_VALUE ? -1 : prev[dst];
        
    }
}