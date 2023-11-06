class SeatManager {

    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    boolean[] reserved;
    public SeatManager(int n) {
        this.reserved=new boolean[n];
        for(int i=1; i<=n; i++){
            minHeap.offer(i);
        }
    }
    
    public int reserve() {
        int top=minHeap.poll();
        reserved[top-1]=true;
        return top;
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
        reserved[seatNumber-1]=false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */