class Solution {
    public int minimumDeviation(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1){
                nums[i]*=2;
            }
        
        }
        int min=nums[0];
        for(int x: nums){
           
            min=Math.min(min, x); 
        }
       
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); 
        for(int x: nums){
            maxHeap.offer(x);
        }
        int max=maxHeap.peek();
        int minDiff=max-min;
        while(!maxHeap.isEmpty()){
            minDiff=Math.min(minDiff, max-min);
            int top=maxHeap.poll();
            
            if(top%2==0){
                top/=2;
               
                min=Math.min(min, top);
                if(maxHeap.peek() > top){
                    
                    maxHeap.offer(top);
                    max=maxHeap.peek();
                    minDiff=Math.min(minDiff, max-min);
                }
                else if(maxHeap.peek() == top){
                   
                    if(top==min){
                        return 0;
                    }
                    else{
                        maxHeap.offer(top);
                        max=maxHeap.peek();
                        minDiff=Math.min(minDiff, max-min);
                    }
                }
                else{
                    if(top%2==1){
                        return top-min;
                    }
                    else{
                        maxHeap.offer(top);
                    }
                    
                    
                }
            }
            else{
                
                return minDiff;
            }
        }
        return minDiff;
        
    }
}