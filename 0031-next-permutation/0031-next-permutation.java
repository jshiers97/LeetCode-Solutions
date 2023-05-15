class Solution {
    public void nextPermutation(int[] nums) {
        int findSwap=-1;
        
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]< nums[i+1]){
                findSwap=i;
                break;
            }
        }
        if(findSwap==-1){
            Arrays.sort(nums);
        }
        else{
            int swap=nums[findSwap+1];
            int swapIndex=findSwap+1;
            
            for(int i=findSwap+1; i<nums.length; i++){
                if(swap > nums[i] && nums[i] > nums[findSwap]){
                    swap=nums[i];
                    swapIndex=i;
                }
            }
            int temp=nums[findSwap];
            nums[findSwap]=swap;
            nums[swapIndex]=temp;
            Arrays.sort(nums, findSwap+1, nums.length);
        }
    }
}