class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int[] time: times){
            if(!map.containsKey(time[0])){
                map.put(time[0], new ArrayList<>());
            }
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        int[] nodes=new int[n+1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[k]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>( (x, y) -> x[1]-y[1]);
        q.offer(new int[]{k , 0});
        
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int current=temp[0];
            int currTime=temp[1];
            
            if(map.containsKey(current)){
                for(int[] next: map.get(current)){
                    int neighbor=next[0];
                    int time=next[1];
                    if(nodes[neighbor] > nodes[current] + time){
                        nodes[neighbor]=nodes[current]+time;
                        q.offer(new int[]{neighbor, nodes[neighbor]});
                    }
                }
            }
            
        }
        int min=0;
        for(int i=1; i<=n; i++){
            min=Math.max(min, nodes[i]);
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}