class Solution {
    public int minimumSubarraysRequired(int[] nums, int mid) {
        int curr=0; 
        int sum=0;
        
        for (int element : nums) {
            if(sum+element <=mid){
                sum+=element;
            }
            else{
                sum=element;
                curr++; 
            }
        }
        
        // Return the number of subarrays, which is the number of splits + 1
        return curr+1;
    }
    
    public int splitArray(int[] nums, int k) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int element : nums) {
            sum += element;
            max = Math.max(max, element);
        }
        
       
        int left = max;
        int right = sum;
        int res=0;
        while (left <= right) {
            
            int mid = (left+right)/2;
            
            
            if (minimumSubarraysRequired(nums, mid) > k) {
                left=mid+1;
                
            } else {
                
                right=mid-1;
                res=mid; 
            }
        }
        
        return res;
    }
}