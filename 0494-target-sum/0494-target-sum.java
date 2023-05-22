class Solution {
    int count=0; 
    int target;
    int[] nums; 
    public int findTargetSumWays(int[] nums, int target) {
        this.target=target;
        this.nums=nums; 
        recurse(0, 0); 
        return count; 
    }
    public void recurse(int index, int sum){
        if(index==nums.length){
            if(target==sum){
                count++;
                return;
            }
            return; 
        }
        recurse(index+1, sum+nums[index]);
        recurse(index+1, sum-nums[index]);
        return; 
        
    }
}