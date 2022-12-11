class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.min(nums[0], nums[1]);
        }
        int left=0;
        int right=nums.length-1;
       
        while(left <= right){
            
            int mid=(right+left)/2;
   
            if(mid==0){
                if(nums[mid+1] > nums[mid]){
                    return nums[mid];
                }
                return nums[mid+1];
                
            }
            else if(mid==nums.length-1 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            else if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
                
                left=mid+1;
            }
            else if(nums[mid]  > nums[left] && nums[mid] < nums[right]){
                right=mid-1;
            }
            else if(nums[mid] <= nums[right] && nums[left] > nums[mid]){
                right=mid-1;
            }
            
        }
        return -1;
    }
}