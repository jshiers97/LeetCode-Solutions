class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output=new HashSet<>(); 
        Set<Integer> dupes=new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            int target=-nums[i];
            if(dupes.contains(nums[i])){
                continue;
            }
            dupes.add(nums[i]);         
            Map<Integer, Integer> map=new HashMap<>(); 
            Set<Integer> set=new HashSet<>(); 
            for(int j=i+1; j<nums.length; j++){
                int complement=target - nums[j];
                if(set.contains(complement)){
                    List<Integer> insert=new ArrayList<>();
                    insert.add(nums[i]);
                    insert.add(complement);
                    insert.add(nums[j]);
                    Collections.sort(insert);
                    output.add(insert);
                }
                set.add(nums[j]); 
            }
        }
        return new ArrayList(output);
    }
    
}