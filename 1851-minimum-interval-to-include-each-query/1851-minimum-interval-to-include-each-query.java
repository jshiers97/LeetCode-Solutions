class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-a[0])-(b[1]-b[0]));
        int[] result=new int[queries.length];
        int[][] q=new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            q[i][0]=i;
            q[i][1]=queries[i];
        }
        Arrays.sort(q, (x, y) -> x[1] - y[1]);
        int j=0; 
        for(int i=0; i<q.length; i++){
            int index=q[i][0];
            int query=q[i][1];
            while(j< intervals.length && intervals[j][0]<= query){
                pq.offer(intervals[j++]);
            }
            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll(); 
            }
            int min=-1;
            if(!pq.isEmpty()){
                int curr[]=pq.peek();
                min=curr[1]-curr[0]+1; 
                
            }
            result[index]=min; 
        }
        return result; 
    }
}