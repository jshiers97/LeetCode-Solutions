class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] output=new int[k][2];
        PriorityQueue<int[]> pq=new PriorityQueue<>( (x, y) ->  y[0] - x[0]);
        for(int i=0; i<points.length; i++){
            int[] point=points[i];
            int dist=(point[0] * point[0]) + (point[1] * point[1]);
            pq.offer(new int[]{dist, i});
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i=0; i<k; i++){
            output[i]=points[pq.poll()[1]];
        }
        return output; 
    }
}