class Solution {
    public int longestArithSeqLength(int[] nums) {
        List<Map<Integer, Integer>> map=new ArrayList<>(); 
        int size=1;
        
        for(int i=0; i<nums.length; i++){
           map.add(new HashMap<Integer, Integer>());
           for(int j=0; j<i; j++){
               int diff=nums[i]-nums[j];
               map.get(i).put(diff, map.get(j).getOrDefault(diff, 1) +1);
               size=Math.max(map.get(i).get(diff), size); 
           }

        }
 
        return size; 
    }
    
}