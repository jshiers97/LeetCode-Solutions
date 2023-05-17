class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> output=new ArrayList<>(); 
        for(int i=0; i<nums.length-2; i++){
            if(nums[i] > 0){
                return output; 
            }
            else if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            else{
                twoSum(nums, i, output); 
            }
        }
        return output; 
    }
    public void twoSum(int[] nums, int i, List<List<Integer>> output){
        Set<Integer> set=new HashSet<>(); 
        int target=0 - nums[i];
        for(int j=i+1; j<nums.length; j++){
            int complement=-nums[j]-nums[i];
            if(set.contains(complement)){
                List<Integer> insert=new ArrayList<>();
                insert.add(nums[i]);
                insert.add(complement);
                insert.add(nums[j]);
                output.add(insert); 
                while(j+1 < nums.length && nums[j]==nums[j+1]){
                    j++; 
                }
            }
            set.add(nums[j]);
            
        }
    }
}