class Solution {
    public int getKth(int lo, int hi, int k) {
        List<Integer> res=new ArrayList<>();
        Map<Integer, List<Integer>> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(); 
        for(int i=lo; i<=hi; i++){
            int step=steps(i);
            if(!map.containsKey(step)){
                map.put(step, new ArrayList<>());
                pq.offer(step);
                
            }
            map.get(step).add(i);
            
        }
        while(!pq.isEmpty()){
            int current=pq.poll();
            for(int x: map.get(current)){
                res.add(x);
            }
        }
       
        return res.get(k-1);
        
    }
    public int steps(int current){
        int step=0;
        while(current!=1){
            if(current%2==1){
                current= current * 3 + 1;
            }
            else{
                current/=2;
            }
            step++;
        }
        return step;
    }
}