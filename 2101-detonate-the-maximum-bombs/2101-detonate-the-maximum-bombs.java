class Solution {
    int max=0; 
    int[][] bombs;
    Map<Integer, Set<Integer>> map;
    public int maximumDetonation(int[][] bombs) {
        this.bombs=bombs;
        
        // do some preprocessing
        
            // this will show which other bombs we can get to from i 
        this.map=new HashMap<>(); 
        for(int i=0; i<bombs.length; i++){
            map.put(i, new HashSet<>()); 
        }
        for(int i=0; i<bombs.length; i++){
            for(int j=0; j<bombs.length; j++){
                if(i==j){
                    continue;
                }
                int[] first=bombs[i];
                int x=first[0];
                int y=first[1];
                int r=first[2];
                int[] second=bombs[j];
                int h=second[0];
                int k=second[1];
                double f=Math.pow(x-h, 2);
                double s=Math.pow(y-k, 2);
                if(Math.sqrt(f+s) <= r){
                    map.get(i).add(j);
                }
            }
        }
        
        //System.out.println(map.get(1).contains(0)); 
        
        
        
        for(int i=0; i<bombs.length; i++){
            Queue<Integer> q=new LinkedList<>(); 
            q.offer(i); 
            check(i, q, new HashSet<>()); 
        }
        return max; 
    }
    public void check(int index, Queue<Integer> q, Set<Integer> seen){
        seen.add(index); 
        while(!q.isEmpty()){
            int curr=q.poll(); 
            for(Integer x: map.get(curr)){
                if(!seen.contains(x)){
                    seen.add(x);
                    q.offer(x); 
                }
            }
            
        }
        max=Math.max(seen.size(), max); 
    }
}