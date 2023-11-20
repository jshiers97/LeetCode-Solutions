class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> reds=new HashMap<>();
        Map<Integer, List<Integer>> blues=new HashMap<>(); 
        Set<Integer> blueSeen=new HashSet<>();
        Set<Integer> redSeen=new HashSet<>(); 
        for(int i=0; i<n; i++){
            reds.put(i, new ArrayList<>()); 
            blues.put(i, new ArrayList<>()); 
        }
        for(int[] edge: redEdges){
            int src=edge[0];
            int dst=edge[1];
            reds.get(src).add(dst);
        }
        for(int[] edge: blueEdges){
            int src=edge[0];
            int dst=edge[1];
            blues.get(src).add(dst);
        }
        Queue<int[]> q=new LinkedList<>(); 
        int[] shortest=new int[n];
        Arrays.fill(shortest, -1);
        shortest[0]=0;
        int dist=0;
        
        //node, color
        // 0 is red, 1 is blue
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        q.offer(new int[]{-1,-1});
        redSeen.add(0);
        blueSeen.add(0); 
        while(!q.isEmpty()){
            int[] curr=q.poll(); 
            int node=curr[0];
            int color=curr[1];
            if(node==-1){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.offer(new int[]{-1,-1});
                    dist++;
                }
            }
            else{
                if(shortest[node]==-1){
                    shortest[node]=dist;
                }
                if(color==0){
                    if(blues.containsKey(node)){
                        for(Integer x: blues.get(node)){
                            if(!blueSeen.contains(x)){
                                q.offer(new int[]{x, 1});
                                blueSeen.add(x);
                            }
                            
                        }
                    }
                }
                else{
                    if(reds.containsKey(node)){
                        for(Integer x: reds.get(node)){
                            if(!redSeen.contains(x)){
                                redSeen.add(x);
                                q.offer(new int[]{x, 0});
                            }
                            
                        }
                    }
                }
            }
        }
        return shortest;
        
    }
}