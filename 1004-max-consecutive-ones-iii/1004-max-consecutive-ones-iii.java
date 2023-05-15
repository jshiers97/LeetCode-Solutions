class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int max=0;
        int curr=0;
        int zeroes=0;
        while(right < nums.length){
            int num=nums[right];
            if(num==1){
                curr++;
            }
            else{
                curr++;
                zeroes++;
            }
            
            while(k<zeroes){
                num=nums[left];
                if(num==1){
                    curr--;
                }
                else{
                    curr--;
                    zeroes--;
                }
                left++;
            }
            max=Math.max(curr, max); 
            right++;
        }
        return max; 
    }
}