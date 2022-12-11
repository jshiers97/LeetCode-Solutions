class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left=0;
        int right=nums1.length-1;
        int total=nums1.length+nums2.length;
        int half=total/2;
        //System.out.println(total);
        boolean odd = total%2==1 ? true : false;
        while(true){
            int mid=Math.floorDiv(left+right, 2);
            int otherMid=half-mid-2;
            
            int Aleft= (mid>=0 && mid<nums1.length) ? nums1[mid] : Integer.MIN_VALUE;
            int Aright= (mid+1>=0 && (mid+1)<nums1.length) ? nums1[mid+1] : Integer.MAX_VALUE;
            int Bleft= (otherMid>=0 && otherMid<nums2.length) ? nums2[otherMid] : Integer.MIN_VALUE;
            int Bright=(otherMid+1>=0 && otherMid+1<nums2.length) ? nums2[otherMid+1] : Integer.MAX_VALUE;
            // System.out.println(Aleft);
            // System.out.println(Aright);
            // System.out.println(Bleft);
            // System.out.println(Bright);

            if(Aleft <= Bright && Bleft<= Aright){
                if(odd){
                    return (double)Math.min(Aright, Bright);
                }
                else{
                    
                    int lower=Math.max(Aleft, Bleft);
                    int higher=Math.min(Aright, Bright);
                    return (double)(lower+higher)/2.0;
                }
            }
            else{
                if(Aleft > Bright){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            
        }
        //return 1.0;
        
        
        
    }
}