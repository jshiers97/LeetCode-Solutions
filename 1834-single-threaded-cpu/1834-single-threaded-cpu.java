class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y){
                //0 index is index in tasks array, 1 is time
                if(x[1]==y[1]){
                    return x[0]- y[0];
                }
                else{
                    return x[1] - y[1];
                }
            }
            
        });
        
        List<int[]> sortedByTime=new ArrayList<>();
        for(int i=0; i<tasks.length; i++){
            int[] task=tasks[i];
            sortedByTime.add(new int[]{task[0], task[1], i});
        }
        
        Collections.sort(sortedByTime, new Comparator<int[]>(){
            @Override
            public int compare(int[]x, int[] y){
                return x[0]-y[0];
            }
        });
       
    
        int timeSortIndex=0;
        
        
        int[] res=new int[tasks.length];
        int resIndex=0;
        //we have mapping of time to index of task we can add to pq
        //we also have pq that will sort available tasks by how long they take
        
        //now, lets start at time smallest, add those to pq, then start
        int[] first=sortedByTime.get(timeSortIndex++);

            
    
        pq.offer(new int[]{first[2], first[1]});
        int time=first[0];
        while(timeSortIndex < sortedByTime.size() && sortedByTime.get(timeSortIndex)[0] <= time){
            pq.offer(new int[]{sortedByTime.get(timeSortIndex)[2], sortedByTime.get(timeSortIndex)[1]});
            timeSortIndex++;
        }
        
        while(!pq.isEmpty()){
            
            int[] curr=pq.poll();

            int currTime=time;
            res[resIndex++]=curr[0];
            currTime+=curr[1];
            time=currTime;
            if(timeSortIndex==sortedByTime.size()){
                continue;
            }
            else if(timeSortIndex<sortedByTime.size() && sortedByTime.get(timeSortIndex)[0]<=time){
                while(timeSortIndex < sortedByTime.size() && sortedByTime.get(timeSortIndex)[0] <= time){
                    pq.offer(new int[]{sortedByTime.get(timeSortIndex)[2], sortedByTime.get(timeSortIndex)[1]});

                    timeSortIndex++;
                }
            }
            else{
                if(!pq.isEmpty()){
                    continue;
                }
                else{
                   time=sortedByTime.get(timeSortIndex)[0];
                    while(timeSortIndex < sortedByTime.size() && sortedByTime.get(timeSortIndex)[0] <= time){
                        pq.offer(new int[]{sortedByTime.get(timeSortIndex)[2], sortedByTime.get(timeSortIndex)[1]});
                       
                        timeSortIndex++;
                    } 
                }
                
            }
            
        }
        return res;
        
    }
}