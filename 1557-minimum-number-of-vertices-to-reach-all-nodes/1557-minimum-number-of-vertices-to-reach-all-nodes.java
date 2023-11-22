class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res=new ArrayList<>(); 
        Map<Integer, List<Integer>> map=new HashMap<>(); 
        int[] indegree=new int[n];
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<edges.size(); i++){
            List<Integer> l=edges.get(i);
            int src=l.get(0);
            int dst=l.get(1);
            map.get(src).add(dst);
            indegree[dst]++;
        }
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                res.add(i);
            }
        }
        return res; 
        
    }
}