class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[n];

        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }

        return bfs(n, adj, degree, seats);
    }
    public long bfs(int n, Map<Integer, List<Integer>> map, int[] degree, int seats){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<n; i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        
        int[] reps=new int[n];
        Arrays.fill(reps, 1);
        long fuel=0;
        while(!q.isEmpty()){
            int node=q.poll(); 
            fuel+=Math.ceil((double) reps[node] / seats);
            for(int neighbor: map.get(node)){
                degree[neighbor]--;
                reps[neighbor]+=reps[node];
                if(degree[neighbor]==1 && neighbor!=0){
                    q.offer(neighbor); 
                }
            }
        }
        return fuel;
            
    }
}