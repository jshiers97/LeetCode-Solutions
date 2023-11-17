class Solution {
    int[] root;
    int n;
    Map<Integer, List<Integer>> map=new HashMap<>(); 
    Map<Integer, List<Integer>> incoming=new HashMap<>();
    
    public int minReorder(int n, int[][] connections) {
        this.root=new int[n];
        this.n=n;
        Set<Integer> fixed=new HashSet<>(); 
        for(int i=0; i<n; i++){
            root[i]=i; 
            map.put(i, new ArrayList<>());
            incoming.put(i, new ArrayList<>());
        }
        
        for(int[] connect: connections){
            int src=connect[0];
            int dst=connect[1];
            incoming.get(dst).add(src);
            map.get(src).add(dst); 
            //map.get(dst).add(src);
            
        }
        int swap=0; 
        //index 0 is one we are flipping, 1 is index we flipping to 
        Queue<int[]> q=new LinkedList<>(); 
        
        //get all of the cities going out of 0
        if(map.containsKey(0)){
            List<Integer> list=map.get(0);
            for(Integer x: list){
                System.out.println("here");
                q.offer(new int[]{x, 0});
            }
        }
        
        // get all of the cities already coming into 0
        if(incoming.get(0).size()>0){
            List<Integer> list=incoming.get(0);
            for(Integer x: list){
                fixed.add(x);
                q.offer(new int[]{x, x});
            }
        }
        fixed.add(0);
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int toFlip=curr[0];
            int flipTo=curr[1];
            System.out.println(toFlip);
            System.out.println(flipTo); 
            //if this happens, this city is already going to 0. In that case, find all of this city's outgoing and flip them
            //also check their incoming
            if(toFlip==flipTo){
                fixed.add(toFlip);
                if(map.containsKey(toFlip)){
                    List<Integer> list=map.get(toFlip);
                    for(Integer x: list){
                        if(fixed.contains(x)){
                            continue;
                        }
                        else{
                            q.offer(new int[]{x, toFlip});
                        }
                        
                    }
                }

                // get all of the cities already coming into 0
                if(incoming.get(toFlip).size()>0){
                    List<Integer> list=incoming.get(toFlip);
                    for(Integer x: list){
                        if(fixed.contains(x)){
                            continue;
                        }
                        else{
                            fixed.add(x);
                            q.offer(new int[]{x, x});  
                        }
                        
                    }
                }
                
                
            }
            //if this happens, we need to flip. THen check both incoming and outgoing 
            else{
                swap++; 
                
                fixed.add(toFlip); 
                if(map.containsKey(toFlip)){
                    List<Integer> list=map.get(toFlip);
                    for(Integer x: list){
                        if(fixed.contains(x)){
                            continue;
                        }
                        else{
                            q.offer(new int[]{x, toFlip});
                        }
                        
                    }
                }

                // get all of the cities already coming into 0
                if(incoming.get(toFlip).size()>0){
                    List<Integer> list=incoming.get(toFlip);
                    for(Integer x: list){
                        if(fixed.contains(x)){
                            continue;
                        }
                        else{
                            fixed.add(x);
                            q.offer(new int[]{x, x});  
                        }
                        
                    }
                }
                
            }
        }
        return swap; 
        
        
    }
    public int find(int x){
        return root[x];
    }
    public void union(int x, int y){
        int findX=find(x);
        int findY=find(y); 
        if(findX!=findY){
            for(int i=0; i<n; i++){
                if(root[i]==findY){
                    root[i]=findX;
                }
            }
        }
    }
}