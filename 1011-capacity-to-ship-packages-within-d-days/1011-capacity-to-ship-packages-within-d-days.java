class Solution {
    int smallest=Integer.MAX_VALUE;
    public int shipWithinDays(int[] weights, int days) {
        int min=weights[0];
        for(int x: weights){
            min=Math.max(min, x);
        }
        if(days==weights.length){
            return min;
        }
    
            
        int max=Integer.MAX_VALUE / 10;
        while(min <= max){
            int mid=(min + max)/2;
            
            
            if(check(weights, days, mid)){
                smallest=Math.min(mid, smallest);
                
                max=mid-1;
            }
            else{
                min=mid+1;
            }
            
        }
        return smallest;
        
    }
    public boolean check(int[] weights, int days, int val){
        int curr=0;
        int currDay=1;
        for(int i=0; i<weights.length; i++){
            if(curr+weights[i] > val){
                currDay++;
                curr=0;
                curr+=weights[i];
            }
            else{
                curr+=weights[i];
            }
        }
        return currDay <=days;
    }
}