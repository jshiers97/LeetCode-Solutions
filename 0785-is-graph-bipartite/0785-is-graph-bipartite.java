class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> a=new HashSet<>(); 
        Set<Integer> b=new HashSet<>(); 
        
        Map<Integer, Set<Integer>> map=new HashMap<>(); 
        for(int i=0; i<graph.length; i++){
            int[] g=graph[i];
            map.put(i, new HashSet<>());
            for(int x: g){
                map.get(i).add(x);
            }
        }
        a.add(0);
        for(int x: graph[0]){
            b.add(x); 
        }
        
        Queue<Integer> q=new LinkedList<>(); 
        for(int i=1; i<graph.length; i++){
            if(a.contains(i)){
                for(int x: graph[i]){
                    if(a.contains(x)){
                        return false;
                    }
                    else{
                        b.add(x);
                    }
                }
            }
            else if(b.contains(i)){
                for(int x: graph[i]){
                    if(b.contains(x)){
                        return false;
                    }
                    else{
                        a.add(x); 
                    }
                }
            }
            else{
                q.offer(i);
            }
                
        }
            
            while(!q.isEmpty()){
                Integer curr=q.poll(); 
                if(a.contains(curr)){
                    for(int x: graph[curr]){
                        if(a.contains(x)){
                            return false;
                        }
                        else{
                            b.add(x);
                        }
                    }
                }
                else if(b.contains(curr)){
                    for(int x: graph[curr]){
                        if(b.contains(x)){
                            return false;
                        }
                        else{
                            a.add(x); 
                        }
                    }
                }
                else{
                    boolean swap=false;
                    for(int x: graph[curr]){
                        //if swap is true, then add i to b and rest to a
                        if(a.contains(x)){
                            swap=true;
                            break;
                        }
                    }
                    //add i to b and rest to a
                    if(swap){
                        b.add(curr);
                        for(int x: graph[curr]){
                            if(b.contains(x)){
                                return false;
                            }
                            else{
                                a.add(x);
                            }
                        }
                    }
                    //add i to a and rest to B
                    else{
                        a.add(curr); 
                        for(int x: graph[curr]){
                            if(a.contains(x)){
                                return false;
                            }
                            else{
                                b.add(x); 
                            }
                        }
                    }
                }
            }
        return true;
        }
       // return true;
    }
