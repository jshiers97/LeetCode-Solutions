class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int x: piles){
            max=Math.max(max, x); 
        }
        int res=max;
        while(min <= max){
            int mid=(min + max)/2;
            
            if(check(piles.clone(), h, mid)){
                
                res=mid;
                max=mid-1; 
                
            }
            else{
                min=mid+1; 
            }
        }
        return res;
    }
    public boolean check(int[] piles, int h, int curr){
        long days=0; 
       
        for(int i=0; i<piles.length; i++){
            if(piles[i] <= curr){
                days++;
                
            }
            else{
                days+= piles[i]/curr;
                if(piles[i]%curr != 0){
                    days++; 
                }
                
            }
        }
        if(days <=h){
            
            return true;
        }
        return false;
    }
}