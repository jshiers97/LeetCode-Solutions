class Solution {
    public int numSubseq(int[] nums, int target) {
        int left=0; 
        int right=nums.length-1; 
        int res=0; 
        int mod=1_000_000_007;
        
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        Arrays.sort(nums); 
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                int temp=(int)(Math.pow(2, right-left) % mod);
                //System.out.println(temp);
                res+= power[right-left];
                res%=mod;
                left++;
                
            }
            
            else{
                right--;
            }
        }
        return res;
    }
}