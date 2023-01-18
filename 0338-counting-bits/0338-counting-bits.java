class Solution {
    public int[] countBits(int n) {
        int[] output=new int[n+1];
        for(int i=1; i<=n; i++){
            output[i]=output[i>>1] + (i & 1);
        }
        return output;
    }
}