class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res=0;
        int left=0;
        int right=k;
        int sum=0;
        for(int i=0; i<k; i++){
            sum+=arr[i];
            
        }
        
        if( (sum/k) >= threshold){
            res++;
            
        }
        //System.out.println(sum);
        while(right < arr.length){
            sum-=arr[left++];
            sum+=arr[right++];
            //System.out.println(sum); 
            if((sum/k) >= threshold){
                res++;
            }
        }
        return res;
    }
}