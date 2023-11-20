class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1==node2){
            return node1;
        }
            
        
        Set<Integer> seen=new HashSet<>(); 
        int[] oneDistance=new int[edges.length];
        Arrays.fill(oneDistance, -1);
        Queue<Integer> q=new LinkedList<>(); 
        q.offer(node1);
        seen.add(node1);
        int dist=0;
        
        while(!q.isEmpty()){
            
            Integer curr=q.poll(); 
            oneDistance[curr]=dist;
            dist++; 
            if(edges[curr]==-1){
                break;
            }
            else{
                if(!seen.contains(edges[curr])){
                    q.offer(edges[curr]);
                    seen.add(edges[curr]);
                }
                
            }
        }
        q.clear();
        q.offer(node2);
        Set<Integer> seen2=new HashSet<>(); 
        seen2.add(node2);
        dist=0;
        int[] twoDistance=new int[edges.length];
        Arrays.fill(twoDistance, -1);
        while(!q.isEmpty()){
            Integer curr=q.poll(); 
            twoDistance[curr]=dist;
            dist++;
            
            if(edges[curr]==-1){
                break;
            }
            else{
                if(!seen2.contains(edges[curr])){
                    seen2.add(edges[curr]);
                    q.offer(edges[curr]);
                }
               
                //seen.add(edges[curr]);
            }
        }
        int res=Integer.MAX_VALUE;
        int resI=-1;
        for(int i=0; i<oneDistance.length; i++){
            // System.out.println(oneDistance[i]);
            // System.out.println(twoDistance[i]);
            if(oneDistance[i]==-1 || twoDistance[i]==-1){
                continue;
            }
            else{
                int temp=Math.max(oneDistance[i], twoDistance[i]);
                if(temp < res){
                    res=temp;
                    resI=i;
                }
            }
            
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        
        return resI; 
    }
}