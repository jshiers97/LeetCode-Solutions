class Solution {
    
    //sort the list by starting time, keep in a queue
    // Keep a Queue of when a room is about to be up, just keep end time. 
    // if we are at another room which a start time before that next room is up in second queue, check if rooms available
    //otherwise, we'll need another room
    
    //if we are at a start time that is at or after the next room is available, first removce it from second qwueue
    //and add one to the number of avialble rooms
    
    
    //every time a room is used, make sure to add its end time to the second queue
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0){
            return 0; 
        }
        int available=1; 
        int needed=1; 
        PriorityQueue<int[]> q=new PriorityQueue<>( (x, y) -> x[0]- y[0]);
        PriorityQueue<Integer> inUse=new PriorityQueue<>(); 
        for(int[] interval: intervals){
            q.offer(interval); 
        }
        while(!q.isEmpty()){
            int[] curr=q.poll(); 
            int start=curr[0];
            int end=curr[1];
            while(!inUse.isEmpty() && inUse.peek() <= start){
                inUse.poll();
                available++; 
            }
            if(available>0){
                available--;
                
            }
            else{
                needed++;
                
            }
            inUse.offer(end); 
        }
        return needed; 
    }
}