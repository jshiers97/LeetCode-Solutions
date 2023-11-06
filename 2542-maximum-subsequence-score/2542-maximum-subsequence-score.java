class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>( (x, y) -> y[1] - x[1]);
        for(int i=0; i<nums2.length; i++){
            maxHeap.offer(new int[]{i, nums2[i]});
        }
        long[] sortedNums1=new long[nums1.length];
        long[] sortedNums2=new long[nums2.length];
        int index=0;
        while(!maxHeap.isEmpty()){
            int[] curr=maxHeap.poll();
            sortedNums1[index]=nums1[curr[0]];
            sortedNums2[index]=curr[1];
            index++;
        }
        long currSum=0;
        PriorityQueue<Long> min=new PriorityQueue<>();
        for(int i=0; i<k; i++){
            currSum+=sortedNums1[i];
            
        }
        for(int i=0; i<k-1; i++){
            min.offer(sortedNums1[i]);
        }
        long max=currSum * sortedNums2[k-1];
        int pointer=k;
        int pointer2=k;
        long pqSum=currSum - sortedNums1[k-1];
        //System.out.println(max);
        while(pointer<sortedNums1.length){
            
            min.offer(sortedNums1[pointer-1]);
            pqSum+=sortedNums1[pointer-1];
            pqSum-=min.poll();
            currSum=sortedNums1[pointer];
            pointer++;
            
            // PriorityQueue<Long> copy=new PriorityQueue<>(min);
            // while(!copy.isEmpty()){
            //     currSum+=copy.poll();
            // }
            currSum+=pqSum;
            max=Math.max(max, currSum * sortedNums2[pointer2]);
            pointer2++;
            
            
        }
        return max;
        
        
    }
}