class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        int min=Integer.MAX_VALUE;
        for(int x: piles){
            
            max=Math.max(x, max); 
            
        }
        if(piles.length==h){
            return max; 
        }
        int left=1;
        int right=max; 
        min=max;
        while(left<=right){
            int mid=(left+right)/2;
            System.out.println(" mid is " + mid);
            if(check(piles.clone(), h, mid)){
                min=Math.min(min, mid);
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return min;
    }
    public boolean check(int[] piles, int h, int num){
        int index=0;
        int count=0;
        while(index<piles.length){
            int temp=piles[index]%num;
            count+= piles[index]/num;
            if(temp>=1){
                count++;
            }
            
            if(count > h){
                return false;
            }
            index++;
        }
        System.out.println("count is " + count); 
        return h>=count;
    }
}