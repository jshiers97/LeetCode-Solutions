class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int curr=0;
        int right=nums.length-1;
        while(curr<=right){
            int c=nums[curr];
            if(c==0){
                int temp=nums[left];
                
                nums[left++]=c;
                nums[curr++]=temp;
                
                
                
            }
            else if(c==2){
                int temp=nums[right];
                nums[right]=c;
                nums[curr]=temp;
                right--;
                
                
            }
            else{
                curr++;
            }
        }
        
        
    }
}