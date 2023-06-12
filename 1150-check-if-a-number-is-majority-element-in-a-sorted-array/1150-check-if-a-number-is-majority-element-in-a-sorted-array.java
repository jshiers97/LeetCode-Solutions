class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count=1; 
        int num=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=num){
                count--;
                if(count==0){
                    num=nums[i];
                    count=1;
                }
            }
            else{
                count++;
            }
        }
        count=0;
        for(int x: nums){
            if(x==num){
                count++;
            }
        }
        if(count <= nums.length/2){
            return false;
        }
        return num==target;
    }
}