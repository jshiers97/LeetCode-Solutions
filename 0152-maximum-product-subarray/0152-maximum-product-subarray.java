class Solution {
    int max; 
    int min;
    public int maxProduct(int[] nums) {
        
        int curr=nums[0];
        int currNeg=nums[0];
        this.max=nums[0];
        for(int i=1; i<nums.length; i++){
            
            
            int tempMax=Math.max(currNeg * nums[i], Math.max(curr*nums[i], nums[i]));
            currNeg=Math.min(currNeg * nums[i], Math.min(curr*nums[i], nums[i]));
            curr=tempMax; 
            max=Math.max(tempMax, max); 
            
        }
        
        return max; 
    }
    
}