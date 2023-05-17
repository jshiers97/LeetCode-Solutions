class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left=0;
        Arrays.sort(nums); 
        List<List<Integer>> output=new ArrayList<>(); 
        while(left<nums.length-2){
            
            int index=left+1; 
            int right=nums.length-1; 
            
            while(index<right){
                int curr=nums[left] + nums[index] + nums[right];
                
                if(curr==0){
                    List<Integer> insert=new ArrayList<>(); 
                    insert.add(nums[left]);
                    insert.add(nums[index]); 
                    insert.add(nums[right]); 
                    output.add(insert); 
                    index++;
                    while(index < right && nums[index]==nums[index-1]){
                        index++;
                    }
                    right--; 
                    while(right > index && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(curr>0){
                    
                    right--;
                }
                else{
                    
                    index++; 
                }
            }
           
            left++;
            while(left < nums.length && nums[left]==nums[left-1] && nums[left]<=0){
                left++;
            }
            if(left==nums.length || nums[left]>0){
                return output; 
            }
        }
        return output; 
    }
}