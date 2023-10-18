class Solution {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    public int[] searchRange(int[] nums, int target) {
        
        int left=0; 
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                min=Math.min(min, mid); 
                max=Math.max(max, mid); 
                searchL(nums, target, mid);
                searchR(nums, target, mid); 
                break;
                
            }
            else if(nums[mid] > target){
                right=mid-1; 
            }
            else{
                left=mid+1; 
            }
        }
        if(min==Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        return new int[]{min, max};
    }
    public void searchR(int[] nums, int target, int start){
        int left=start; 
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                
                max=Math.max(max, mid); 
                left=mid+1; 
                
            }
            else if(nums[mid] > target){
                right=mid-1; 
            }
            else{
                left=mid+1; 
            }
        }
        
    }
    public void searchL(int[] nums, int target, int start){
        int left=0; 
        int right=start;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                
                min=Math.min(min, mid); 
                right=mid-1;
                
            }
            else if(nums[mid] > target){
                right=mid-1; 
            }
            else{
                left=mid+1; 
            }
        }
    }
}