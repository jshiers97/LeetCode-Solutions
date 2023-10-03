class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Map<Integer, Integer> map=new HashMap<>();
        //VAL , number of times it has happened
        
        Deque<Integer> dq=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        
        
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[i]>= nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.offerLast(i); 
        }
        res.add(nums[dq.peekFirst()]);
        for(int i=k; i<nums.length; i++){
            if(dq.peekFirst()==i-k){
                dq.pollFirst(); 
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
            
        }
        return res.stream().mapToInt(i ->i).toArray(); 
    }
}