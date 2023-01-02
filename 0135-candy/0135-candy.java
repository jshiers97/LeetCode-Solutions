class Solution {
    public int candy(int[] ratings) {
        int[] candies=new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        
        int sum=0;
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                if(i-1>=0){
                    candies[i]=Math.max(candies[i], candies[i+1] +1);
                }
                else{
                    candies[i]=candies[i+1]+1;
                }
                
            }
        }
        for(int x: candies){
            sum+=x;
        }
        return sum;
    }
}