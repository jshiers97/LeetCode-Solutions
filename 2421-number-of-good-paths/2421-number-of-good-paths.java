class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    int[] root;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>(); 
        int n=vals.length;
        for(int[] edge: edges){
            int src=edge[0];
            int dst=edge[1];
            if(!map.containsKey(src)){
                map.put(src, new ArrayList<>()); 
            }
            if(!map.containsKey(dst)){
                map.put(dst, new ArrayList<>()); 
            }
            map.get(src).add(dst); 
            map.get(dst).add(src); 
        }
        //this.root=new int[vals.length];
        
        // 
        UnionFind dsu=new UnionFind(n); 
        // contains array containing all nodes having value x 
        //sorts keys in non-decreasing order
        TreeMap<Integer, List<Integer>> valuesToNodes=new TreeMap<>(); 
        for(int i=0; i<vals.length; i++){
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i); 
        }
        
        int goodPaths=0; 
        
        for(int value: valuesToNodes.keySet()){
            for(int node: valuesToNodes.get(value)){
                if(!map.containsKey(node)){
                    continue;
                }
                for(int neighbor: map.get(node)){
                    if(vals[node]>= vals[neighbor]){
                        dsu.union_set(node, neighbor);
                    }
                }
            }
            
            
            //map to compute the number of nodes under observation (with same values) in each of the sets
            Map<Integer, Integer> group=new HashMap<>(); 
            for(int u: valuesToNodes.get(value)){
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
                
            }
            
            //for each set of "size" add size * 
            for(int key: group.keySet()){
                int size=group.get(key); 
                goodPaths+= size * (size+1) /2; 
            }
        }
        return goodPaths;
        
    }
    public int find(int x){
        return root[x];
    }
    public void union(int x, int y){
        int findX=find(x); 
        int findY=find(y); 
        if(findX!=findY){
            for(int i=0; i<root.length; i++){
                if(root[i]==findX){
                    root[i]=findY;
                }
            }
        }
    }
}