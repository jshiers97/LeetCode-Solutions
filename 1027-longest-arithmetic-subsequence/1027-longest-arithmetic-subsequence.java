class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] map=new HashMap[nums.length];
        int size=1;
        
        for(int i=0; i<nums.length; i++){
            map[i]=new HashMap<>(); 
           for(int j=0; j<i; j++){
               int diff=nums[i]-nums[j];
               map[i].put(diff, map[j].getOrDefault(diff, 1) +1);
               size=Math.max(map[i].get(diff), size); 
           }
            
            
        }
        
        
        return size; 
    }
    
}