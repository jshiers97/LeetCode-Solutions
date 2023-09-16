class Solution {
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                recurse(nums, i);
            }
        }
        return output; 
        
    }
    public void recurse(int[] nums, int i){
        int low=i+1; 
        int hi=nums.length-1;
        while(low < hi){
            int sum=nums[i]+nums[low]+nums[hi];
            if(sum==0){
                List<Integer> insert=new ArrayList<>();
                insert.add(nums[i]);
                insert.add(nums[low++]);
                insert.add(nums[hi--]);
                output.add(insert);
                while(low < hi && nums[low]==nums[low-1]){
                    low++;
                }
            }
            else if(sum > 0){
                hi--;
            }
            else{
                low++;
            }
        }
        return;
    }
}