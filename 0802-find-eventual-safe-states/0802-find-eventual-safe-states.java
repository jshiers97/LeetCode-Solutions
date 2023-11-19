class Solution {
    List<Integer> safe=new ArrayList<>(); 
    Set<Integer> skip=new HashSet<>(); 
    Set<Integer> not=new HashSet<>(); 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> outgoing=new HashMap<>(); 
        Map<Integer, List<Integer>> incoming=new HashMap<>(); 
        int[] indegree= new int[graph.length];
        
        for(int i=0; i<graph.length; i++){
            
            incoming.put(i, new ArrayList<>()); 
            
        }
        
        for(int i=0; i<graph.length; i++){
            
            for(int j=0; j<graph[i].length; j++){
                incoming.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(indegree[i]==0){
                //System.out.println(i); 
                q.offer(i); 
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll(); 
            safe.add(curr); 
            List<Integer> neighbors=incoming.get(curr); 
            for(Integer neighbor: neighbors){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.offer(neighbor); 
                }
            }
        }
        Collections.sort(safe);
        return safe;
        
        
        
    }
    
}