class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        //this is list of available servers by lowest weight first then index
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int y[]){
                //index 0 is value, 1 is index of the server
                if(x[0]==y[0]){
                    return x[1]-y[1];
                }
                else{
                    return x[0]-y[0];
                }
            }
        });
        
        //this is list of processing tasks by first time done on top
        PriorityQueue<int[]> processing=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int y[]){
                //index 0 is finished time; index 1 is the index of the server
                
                if(x[0]==y[0]){
                    return x[1]-y[1];
                }
                else{
                    return x[0] - y[0];
                }
            }
        });
        
        for(int i=0; i<servers.length; i++){
            minHeap.offer(new int[]{servers[i], i});
        }
        int currTime=0;
        int index=0;
        int[] res=new int[tasks.length];
        int resIndex=0;
        while(index < tasks.length){
            //System.out.println(index); 
            while(!processing.isEmpty() && processing.peek()[0] <= currTime){
                
                int[] finished=processing.poll();
                int servIndex=finished[1];
                
                minHeap.offer(new int[]{servers[servIndex], servIndex});
            }
            
            if(minHeap.size() > 0){
                while(minHeap.size() > 0 && index<tasks.length && currTime>=index){
                    
                    int[] server=minHeap.poll();
                    res[resIndex++]=server[1];
                    processing.offer(new int[]{currTime + tasks[index], server[1]});
                    index++;
                }
                
            }
            // else{
            //     int[] finished=processing.poll();
            //     int servIndex=finished[1];
            //     currTime=finished[0];  
            //     minHeap.offer(new int[]{servers[servIndex], servIndex});
            //     while(!processing.isEmpty() && processing.peek()[0] <= currTime){
            //         int[] finished1=processing.poll();
            //         int servIndex1=finished1[1];
            //         minHeap.offer(new int[]{servers[servIndex], servIndex1});
            //     }
            // }
            
                if(minHeap.isEmpty()){
                    currTime=processing.peek()[0];
                }
                else{
                    currTime=index;
                }
            
            
        }
        return res;
    }
}