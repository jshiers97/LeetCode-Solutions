class Solution {
    boolean output=true;
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        if(edges.length != n-1){
            return false;
        }
        if(edges.length==0){
            return n==1;
        }
        
        for(int[] edge: edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0], new ArrayList<>());
            }
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        

        Queue<Integer> q=new LinkedList<>();
        q.offer(edges[0][0]);
        Set<Integer> seen=new HashSet<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neighbor: map.get(curr)){
                
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return seen.size()==n;

    }
}