class Solution {
    int[] root;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList=new HashMap<>(); 
        this.root=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList<>()); 
            root[i]=i;
            
        }
        for(int[] prereq: prerequisites){
            int first=prereq[0];
            int second=prereq[1];
            adjList.get(first).add(second); 
            
        }
        List<Boolean> res=new ArrayList<>(); 
        for(int[] query: queries){
            int preReq=query[0];
            int end=query[1];
            Set<Integer> seen=new HashSet<>();
            seen.add(preReq); 
            Queue<Integer> q=new LinkedList<>(); 
            boolean added=false;
            q.offer(preReq); 
            while(!q.isEmpty()){
                int curr=q.poll(); 
                
                List<Integer> neighbors=adjList.get(curr); 
                for(int neighbor: neighbors){
                    if(neighbor==end){
                        res.add(true); 
                        added=true;
                        break;
                        
                    }
                    else{
                        if(!seen.contains(neighbor)){
                            seen.add(neighbor); 
                            q.offer(neighbor); 
                        }
                    }
                }
                if(added){
                    break;
                }
            }
            if(!added){
                res.add(false); 
            }
            
        }
        return res; 
        
        
        
    }
    
}