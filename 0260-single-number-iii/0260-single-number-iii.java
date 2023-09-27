class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask=0; 
        for(int x: nums){
            bitmask^=x;
        }
        int diff=bitmask & (-bitmask); 
        int x=0; 
        for(int num: nums){
            if((num & diff)!=0 ){
                x^=num;
            }
        }
        return new int[]{x, bitmask ^ x};
        
    }
}