class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while(left <=right){
            int mid=(left+right)/2; 
            if((mid-1 < 0 && nums[mid]>nums[mid+1] ) || (mid+1 >=nums.length && nums[mid] > nums[mid-1]) || (mid-1 >=0 && mid+1<nums.length && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])){
                return mid;
            }
           else if(mid+1  <nums.length && nums[mid+1]> nums[mid]){
               left=mid+1;
           }
           else{
               right=mid-1;
           }
        }
               return 0;
    }
}