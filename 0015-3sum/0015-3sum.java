class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output=new HashSet<>(); 
        Set<Integer> dupes=new HashSet<>();
        Map<Integer, Integer> map=new HashMap<>(); 
        for(int i=0; i<nums.length-2; i++){
            int target=-nums[i];
            if(dupes.add(nums[i])){
                
            
                
            
            //Set<Integer> set=new HashSet<>(); 
            for(int j=i+1; j<nums.length; j++){
                int complement=-nums[i] - nums[j];
                if(map.containsKey(complement) && map.get(complement)==i){
                    List<Integer> insert=new ArrayList<>();
                    insert.add(nums[i]);
                    insert.add(complement);
                    insert.add(nums[j]);
                    Collections.sort(insert);
                    output.add(insert);
                }
                map.put(nums[j], i); 
            }
            }
        }
        return new ArrayList(output);
    }
    
}