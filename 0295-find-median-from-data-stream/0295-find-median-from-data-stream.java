class MedianFinder {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>( (x, y) -> y-x);
    int size;
    public MedianFinder() {
        this.size=0;
    }
    
    public void addNum(int num) {
        size++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() != minHeap.size()-1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(size%2==1){
            return (double) minHeap.peek();
        }
        else{
            double res=(double)minHeap.peek() + maxHeap.peek();
            return res/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */