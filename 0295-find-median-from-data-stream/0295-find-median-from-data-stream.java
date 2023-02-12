class MedianFinder {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>(); 
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>( (x, y) -> y-x);
    int size;
    public MedianFinder() {
        this.size=0;
    }
    
    public void addNum(int num) {
        minHeap.offer(num); 
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() > minHeap.size()){
            minHeap.offer(maxHeap.poll()); 
        }
    }
    
    public double findMedian() {
        
        if((minHeap.size() + maxHeap.size() ) %2 ==1){
            System.out.println("here1");
            return (double) minHeap.peek(); 
        }
        else{
            System.out.println("here");
            return (double) (maxHeap.peek() + minHeap.peek() )/2.0; 
            
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */