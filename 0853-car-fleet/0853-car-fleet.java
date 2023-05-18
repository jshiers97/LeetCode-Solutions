class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq=new PriorityQueue<>( (x,y )-> (y[0] -x[0]));
        for(int i=0; i<speed.length; i++){
            int[] car=new int[]{position[i], speed[i]};
            pq.offer(car); 
        }
        
        double slowest=0;
        int groups=0;
        while(!pq.isEmpty()){
            int[] car=pq.poll();
            int spee=car[1];
            int positio=car[0];
            double total= (double)(target - positio) / spee; 
            //System.out.println(total); 
            if(total>slowest){
                slowest=total; 
                groups++; 
            }
        }
        return groups; 
    }
}