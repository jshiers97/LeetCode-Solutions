class Solution {
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int max=0;
        for(int i=0; i<height.length; i++){
            left[i]=max;
            max=Math.max(max, height[i]);
        }
        max=0;
        for(int i=height.length-1; i>=0; i--){
            right[i]=max;
            max=Math.max(max, height[i]);
        }
        int water=0; 
        for(int i=1; i<height.length; i++){
            int temp= Math.min(left[i], right[i]) - height[i];
            if(temp > 0){
                water+=temp; 
            }
        }
        return water;
    }
}