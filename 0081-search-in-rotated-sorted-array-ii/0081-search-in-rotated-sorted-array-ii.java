class Solution {
    public boolean search(int[] nums, int target) {
        int left=0; 
        int right=nums.length-1;
        System.out.println(nums.length);
        int temp=0; 
        boolean search=false;
        if(nums[left]==nums[right] && left!=right && target !=nums[left]){
            temp=nums[left];
            search=true;
        }
        while(left <= right && search && nums[left]==temp){
            left++; 
        }
        while(left <=right && search && nums[right]==temp){
            right--; 
        }
        //int temp=(left+right)/2;
       // System.out.println(nums[temp] + "    " + temp);
        while(left <=right){
            int mid=(left+right)/2; 
            
            if(nums[mid]==target){
                return true;
            }
            
            
            if(nums[mid]>= nums[left] && nums[mid]<=nums[right]){
                
                if(nums[mid] < target){
                    left=mid+1;
                }
                else{
                    right=mid-1; 
                }
            }
            else if(nums[left]==nums[right]){
                
                if(nums[mid] > target && nums[left]<=target){
                    right=mid-1; 
                }
                else{
                    left=mid+1; 
                }
            }
            else if(nums[mid]==nums[right]){
                
                right=mid-1; 
            }
            else if(nums[mid]==nums[left]){
                
                left=mid+1; 
            }
            else if(nums[mid]<nums[right]){
                
                if(target > nums[right]){
                    right=mid-1; 
                }
                else{
                    left=mid+1; 
                }
            }
            else{
                
                if(nums[mid] > target && nums[left]<=target){
                    right=mid-1; 
                }
                else{
                    left=mid+1; 
                }
            }
        }
        return false;
    }
}