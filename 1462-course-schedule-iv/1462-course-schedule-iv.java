class Solution {
    Map<Integer, List<Integer>> map=new HashMap<>(); 
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree=new int[numCourses];
        List<Set<Integer>> list=new ArrayList<>(); 
        
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
            //list.add(new HashSet<>()); 
        }
        for(int i=0; i<prerequisites.length; i++){
            int[] curr=prerequisites[i];
            map.get(curr[1]).add(curr[0]);
            //indegree[curr[1]]++;
        }
        
        
        
        
        List<Boolean> res=new ArrayList<>(); 
        for(int[] query: queries){
            int zero=query[0];
            int one=query[1];
            if(check(one, zero)){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
    
    public boolean check(int zero, int one){
        Queue<Integer> q=new LinkedList<>(); 
        Set<Integer> seen=new HashSet<>();
        seen.add(zero);
        q.offer(zero);
        while(!q.isEmpty()){
            int curr=q.poll();
           
            seen.add(curr);
            if(curr==one){
                return true;
            }
            
            else{
                List<Integer> neighbors= map.get(curr);
                for(Integer x : neighbors){
                    if(!seen.contains(x)){
                        q.offer(x);
                        seen.add(x);
                    }
                    
                }
                
            }
            
            
           
            
        }
        return false;
        
    }
    
}