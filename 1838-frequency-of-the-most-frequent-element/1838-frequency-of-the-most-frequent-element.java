class Solution {
    public int maxFrequency(int[] nums, int k) {
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums); 
        int largest=0; 
        for(int i=1; i<nums.length; i++){
            if(i+1 < nums.length && nums[i+1]==nums[i]){
                continue;
            }
            int currOps=k;
            int curr=1; 
            for(int j=i-1; j>=0; j--){
                if(nums[i]-nums[j] <= currOps){
                    currOps-=(nums[i]-nums[j]);
                    curr++; 
                }else{
                    break;
                }
            }
            largest=Math.max(largest, curr); 
            
        }
        return largest;
    }
}