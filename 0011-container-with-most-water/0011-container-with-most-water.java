class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1; 
        int maxArea=0;
        while(left < right){
            int currArea=right - left;
            currArea*=Math.min(height[right], height[left]); 
            maxArea=Math.max(maxArea, currArea); 
            if(height[right] > height[left]){
                left++;
            }
            else{
                right--; 
            }
        }
        return maxArea;
    }
}