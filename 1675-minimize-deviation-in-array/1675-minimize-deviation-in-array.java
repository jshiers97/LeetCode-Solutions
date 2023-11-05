class Solution {
    public int minimumDeviation(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1){
                nums[i]*=2;
            }
        
        }
        int min=nums[0];
        for(int x: nums){
            System.out.println(x);
            min=Math.min(min, x); 
        }
        System.out.println(min + "here is min");
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); 
        for(int x: nums){
            maxHeap.offer(x);
        }
        int max=maxHeap.peek();
        int minDiff=max-min;
        while(!maxHeap.isEmpty()){
            minDiff=Math.min(minDiff, max-min);
            int top=maxHeap.poll();
            System.out.println(top);
            if(top%2==0){
                top/=2;
                System.out.println("new top is " + top);
                min=Math.min(min, top);
                if(maxHeap.peek() > top){
                    System.out.println("her1");
                    maxHeap.offer(top);
                    max=maxHeap.peek();
                    minDiff=Math.min(minDiff, max-min);
                }
                else if(maxHeap.peek() == top){
                    System.out.println("here weird");
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
                    System.out.println("her2");
                    
                }
            }
            else{
                System.out.println("her3`");
                return minDiff;
            }
        }
        return minDiff;
        
    }
}