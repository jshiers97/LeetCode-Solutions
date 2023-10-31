class Solution {
    Map<Integer, Integer> G=new HashMap<>();
    
    public int numTrees(int n) {
        G.put(0,1);
        if(G.containsKey(n)){
            return G.get(n); 
        }
        int res=0; 
        for(int i=1; i<=n; i++){
            res+=numTrees(i-1) * numTrees(n-i);
            //G.put(i, curr);
        }
        G.put(n, res);
        return res;
        
    }
    
}