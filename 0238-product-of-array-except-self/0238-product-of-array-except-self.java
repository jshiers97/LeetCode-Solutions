class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        left[0]=1;
        int prod=1; 
        for(int i=1; i<nums.length; i++){
            prod*=nums[i-1];
            left[i]=prod;
        }
        int[] right=new int[nums.length];
        right[nums.length-1]=1;
        prod=1;
        for(int i=nums.length-2; i>=0; i--){
            prod*=nums[i+1];
            right[i]=prod;
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=left[i]*right[i];
        }
        return nums; 
    }
}