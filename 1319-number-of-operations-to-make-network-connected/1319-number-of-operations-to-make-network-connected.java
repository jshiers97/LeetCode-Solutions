class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1; 
        }
        int[] root=new int[n];
        for(int i=0; i<n; i++){
            root[i]=i;
        }
        int change=0;
        for(int[] connection: connections){
            int x=connection[0];
            int y=connection[1];
            if(find(root, x)!=find(root, y)){
                union(x, y, root);
            }
            else{
                change++; 
            }
            
        }
        Set<Integer> unique=new HashSet<>();
      
        int temp=0;
        for(int i=0; i<root.length; i++){
           
            if(!unique.contains(root[i])){
                unique.add(root[i]);
                temp++;
            }
        }
        return Math.min(change, temp-1);
    }
    public void union(int x, int y, int[] root){
        int findx=find(root, x);
        int findy=find(root, y);
        if(findx!=findy){
            for(int i=0; i<root.length; i++){
                if(root[i]==findy){
                    root[i]=findx;
                }
            }
        }
    }
    public int find(int[] root, int find){
        return root[find];
    }
}