class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        PriorityQueue<int[]> sort=new PriorityQueue<>( (x, y) -> y[2] - x[2]);
        for(int i=0; i<speed.length; i++){
            sort.offer(new int[]{i, speed[i], efficiency[i]});
        }
            
        long max=0; 
        //Map<Integer, Integer> map=new HashMap<>(); 
        int[] sortedSpeed=new int[speed.length];
        int[] sortedEfficiency=new int[efficiency.length];
        int index=0;
        while(!sort.isEmpty()){
            int[] curr=sort.poll(); 
            sortedSpeed[index]=curr[1];
            sortedEfficiency[index]=curr[2];
            //map.put(curr[0], index);
            index++; 
        }
        
        //now sorted from highest efficiency to lowest
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
        long speedSum=0; 
        for(int i=0; i<sortedEfficiency.length; i++){
            int currEfficiency=sortedEfficiency[i];
            int currSpeed=sortedSpeed[i];
            while(minHeap.size() > k-1){
                speedSum-=minHeap.poll(); 
            }
            minHeap.offer(currSpeed);
            speedSum+=currSpeed;
            max=Math.max(max, speedSum * currEfficiency); 
            
        }
        return (int)(max % mod); 
        
            
    }
}