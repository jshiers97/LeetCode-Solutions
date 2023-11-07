class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> maxHeap=new PriorityQueue<>(new Comparator<String>(){
            public int compare(String one, String two){
                if(one.length()==two.length()){
                 
                    return two.compareTo(one);
                }
                else{
                    return two.length() - one.length();
                }
            }
        }); 
        for(String x: nums){
            
            maxHeap.offer(x); 
        }
        for(int i=0; i<k-1; i++){
            maxHeap.poll(); 
        }
        return maxHeap.poll();
    }
}