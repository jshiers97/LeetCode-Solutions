class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1); 
        }
        return recurse( nums1.length, nums1, nums2.length, nums2, dp);
        
    }
    public int recurse(int n1, int[] nums1, int n2, int[] nums2, int[][] memo){
        if(n1<=0 || n2 <= 0){
            return 0;
        } 
        if(memo[n1][n2]!=-1){
            return memo[n1][n2];
        }
        else if(nums1[n1-1]==nums2[n2-1]){
            memo[n1][n2]=1+recurse(n1-1, nums1, n2-1, nums2, memo);
        }
        else{
            memo[n1][n2]=Math.max(recurse(n1-1, nums1, n2, nums2, memo), recurse(n1, nums1, n2-1, nums2, memo));
        }
        return memo[n1][n2]; 
    }
}