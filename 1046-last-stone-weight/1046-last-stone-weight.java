class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>( (x, y) -> (y-x));
        for(int stone: stones){
            pq.offer(stone);
            
        }
        while(!pq.isEmpty()){
            int largest=pq.poll();
            if(pq.isEmpty()){
                return largest;
            }
            int second=pq.poll();
            largest-=second;
            if(largest > 0){
                pq.offer(largest);
            }
        }
        return 0;
    }
}