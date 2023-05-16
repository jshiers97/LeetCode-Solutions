class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>( (x, y) -> x[1]-y[1]);
        Map<Integer, Integer> count=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 0);
            }
            count.put(nums[i], count.get(nums[i])+1);
        }
        for(int x: count.keySet()){
            pq.offer(new int[]{x, count.get(x)});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res=new int[k];
        for(int i=0; i<k; i++){
            res[i]=pq.poll()[0];
        }
        return res; 
    }
}