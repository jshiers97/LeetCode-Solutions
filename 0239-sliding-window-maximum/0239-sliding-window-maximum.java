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
            while(!dq.isEmpty() && i-k>=dq.peekFirst()){
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && nums[i]>= nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
            
            
        }
        return res.stream().mapToInt(i ->i).toArray(); 
    }
}