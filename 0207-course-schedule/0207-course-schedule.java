class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] prereq: prerequisites){
            int first=prereq[0];
            int second=prereq[1];
            indegree[second]++;
            if(!map.containsKey(first)){
                map.put(first, new ArrayList<>()); 
            }
            map.get(first).add(second); 
        }
        Queue<Integer> q=new LinkedList<>(); 
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.offer(i); 
            }
        }
        while(!q.isEmpty()){
            int course=q.poll(); 
            List<Integer> list=map.get(course);
            if(list==null){
                continue; 
            }
            for(int n: list){
                indegree[n]--;
                if(indegree[n]==0){
                    q.offer(n); 
                }
            }
        }
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]>0){
                return false; 
            }
        }
        return true; 
    }
}