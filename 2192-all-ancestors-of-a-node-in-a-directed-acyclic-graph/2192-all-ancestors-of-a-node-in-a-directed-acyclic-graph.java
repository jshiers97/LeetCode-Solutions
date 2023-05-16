class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result=new ArrayList<>();
          Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<n; i++){
            result.add(new ArrayList<>()); 
            map.put(i, new ArrayList<>());
        }
      
        for(int[] edge: edges){
            int from=edge[0];
            int to=edge[1];
            
            map.get(to).add(from); 
        }
        for(int i=0; i<n; i++){
            Queue<Integer> q=new LinkedList<>();
            List<Integer> temp=map.get(i);
            Set<Integer> seen=new HashSet<>();
            
            for(int x: temp){
                q.offer(x);
                seen.add(x);
            }
            while(!q.isEmpty()){
                int curr=q.poll();
                
                result.get(i).add(curr);
                List<Integer> ancest=map.get(curr);
                for(int x: ancest){
                    if(!seen.contains(x)){
                        q.offer(x);
                        seen.add(x);
                    }
                    //q.offer(x);
                }
            }
            Collections.sort(result.get(i));
        }
        
        return result;
        
    }
}