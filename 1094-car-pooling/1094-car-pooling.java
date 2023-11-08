class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq=new PriorityQueue<>( (x, y) -> x[1]-y[1]);
        PriorityQueue<int[]> done=new PriorityQueue<>( (x, y) -> x[2]-y[2]);
        for(int[] trip: trips){
            pq.offer(trip);
        }
        int inUse=0;
        while(!pq.isEmpty()){
            int[] trip=pq.poll();
            int pass=trip[0];
            int from=trip[1];
            int to=trip[2];
            while(!done.isEmpty() && from >= done.peek()[2]){
                int[] finish=done.poll();
                inUse-=finish[0];
            }
            if(inUse+pass > capacity){
                return false;
            }
            else{
                inUse+=pass;
                done.offer(trip);
            }
            
            
        }
        return true;
    }
}