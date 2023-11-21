class Solution {
    public int minScore(int n, int[][] roads) {
        // src to dst, cost
        Map<Integer, List<Pair<Integer, Integer>>> map=new HashMap<>(); 
        int[] dist=new int[n+1];
        for(int i=0; i<roads.length; i++){
            int[] road=roads[i];
            int src=road[0];
            int dst=road[1];
            int cost=road[2];
            if(!map.containsKey(src)){
                map.put(src, new ArrayList<>()); 
            }
            if(!map.containsKey(dst)){
                map.put(dst, new ArrayList<>()); 
            }
            map.get(src).add(new Pair<>(dst, cost));
            map.get(dst).add(new Pair<>(src, cost));
            //indegree[src]++;
            //indegree[dst]++;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Set<Integer> set=new HashSet<>();
        set.add(1);
        Queue<Integer> q=new LinkedList<>(); 
        q.offer(1);
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node=q.poll(); 
             //System.out.println(node);
            for(Pair<Integer, Integer> p: map.get(node)){
                int dst=p.getKey();
                int cost=p.getValue();
                if(dist[dst] <= cost){
                    continue;
                }
                else{
                    dist[dst]=cost;
                    min=Math.min(cost, min); 
                    q.offer(dst);
                    //set.add(dst);
                }
                
                //indegree[dst]--;
                
                //if(indegree[dst]==1){
                
                //}
            }
        }
        return min;
    }
}