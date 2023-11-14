class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int x: nums){
            sum+=x; 
        }
        if(sum%k!=0){
            return false;
        }
        boolean[] used=new boolean[nums.length];
        //Arrays.sort(nums);
        //reverse(nums);
        return backtrack(0, nums, k, 0, 0, sum/k, used);
        
    }
    public boolean backtrack(int index, int[] nums, int k, int curr, int partitions, int target, boolean[] used){
        if(partitions==k){
            return true;
        }
        if(curr>target){
            return false;
        }
        if(curr==target){
            return backtrack(0, nums, k, 0, partitions+1, target, used);
            //return backtrack(arr, 0, nums, k, 0, partitions+1, target, used);
        }
        boolean found=false;
        
        for(int i=index; i<nums.length; i++){
            
            if(used[i]){
                continue;
            }
            else{
                used[i]=true;
                found=found || backtrack(i+1, nums, k, curr+nums[i], partitions, target, used);
                used[i]=false;
            }
            
        }
        return found; 
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}