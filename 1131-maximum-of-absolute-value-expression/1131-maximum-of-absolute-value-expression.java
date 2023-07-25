class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int max4=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int min3=Integer.MAX_VALUE;
        int min4=Integer.MAX_VALUE;
        for(int i=0; i<arr1.length; i++){
            max1=Math.max(arr1[i] + arr2[i] + i, max1);
            max2=Math.max(arr1[i] - arr2[i] + i, max2);
            max3=Math.max(arr1[i] + arr2[i] - i, max3);
            max4=Math.max(arr1[i] - arr2[i] - i, max4);
            min1=Math.min(arr1[i] + arr2[i] + i, min1);
            min2=Math.min(arr1[i] - arr2[i] + i, min2);
            min3=Math.min(arr1[i] + arr2[i] - i, min3);
            min4=Math.min(arr1[i] - arr2[i] - i, min4);
            
        }
        int maxVal=Math.max(max1-min1, max2-min2);
        int maxVal2=Math.max(max3-min3, max4-min4);
        return Math.max(maxVal, maxVal2);
        
    }
}