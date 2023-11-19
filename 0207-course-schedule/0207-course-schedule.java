class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map=new HashMap<>(); 
        int[] indegree=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>() );
        }
        for(int i=0; i<prerequisites.length; i++){
            int[] curr=prerequisites[i];
            indegree[curr[0]]++;
            map.get(curr[1]).add(curr[0]);
            
        }
        Queue<Integer> q=new LinkedList<>(); 
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll(); 
            for(Integer x: map.get(curr)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.offer(x); 
                }
            }
        }
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}