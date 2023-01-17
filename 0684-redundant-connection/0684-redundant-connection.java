class Solution {
    int[] root;
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList=new HashMap<>();
        for(int[] edge: edges){
            if(!adjList.containsKey(edge[0])){
                adjList.put(edge[0], new ArrayList<>());
            }
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        //number of vertices in graph
        int n=adjList.size();
        
        this.root=new int[n+1];
        for(int i=1; i<root.length; i++){
            root[i]=i;
        }
        
        int edgesNeededCount=0;
        int[] lastExtra=new int[2];
        for(int[] edge: edges){
            if(find(edge[0])!= find(edge[1]) ){
                union(edge[0], edge[1]);
            }
            else{
                lastExtra[0]=edge[0];
                lastExtra[1]=edge[1];
            }
        }
        return lastExtra;
        
            
    }
    public int find(int x){
        return root[x];
    }
    public void union(int x, int y){
        
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            for(int i=0; i<root.length; i++){
                if(root[i]==rootY){
                    root[i]=rootX;
                }
            
            }
        }
    }
}
