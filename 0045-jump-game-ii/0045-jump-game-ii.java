class Solution {
    public int jump(int[] nums) {
        int[] jumps=new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0]=0;
        int jump=1;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length && j<=i+nums[i]; j++){
                jumps[j]=Math.min(jumps[j], jumps[i]+1);
            }
            
        }
        return jumps[nums.length-1];
    }
}