class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0; 
        int right=nums.length-1;
        while(left < right){
            
            int mid=(left+right)/2;
            int curr=nums[mid];
            if(mid+1 < nums.length && nums[mid+1]==curr){
                if((mid-left)%2==1){
                    right=mid-1;
                }
                else{
                    left=mid+2;
                }
            }
            else if(mid-1 >=0 && nums[mid-1]==curr){
                if((right-mid )%2==1){
                    left=mid+1;
                }
                else{
                    right=mid-2;
                }
            }
            else{
                return curr;
            }
        }
        return nums[left];
    }
}