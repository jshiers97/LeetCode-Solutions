class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int steps=0;
        for(int i=nums.length-1; i>=0; i--){
            steps+=nums[i] - nums[0];
        }
        return steps;
        
    }
}