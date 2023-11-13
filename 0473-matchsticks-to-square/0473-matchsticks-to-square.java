class Solution {
    int[] sums=new int[4]; 
    public boolean makesquare(int[] matchsticks) {
        int sum=0; 
        for(int x: matchsticks){
            sum+=x;
        }
        if(sum%4!=0){
            return false; 
        }
        Arrays.sort(matchsticks); 
        if(matchsticks[matchsticks.length-1]> (sum/4)){
            return false;
        }
        return backtrack(0, matchsticks, sum/4); 
        
    }
    public boolean backtrack(int index, int[] matchsticks, int target){
        if(index==matchsticks.length ){
            return sums[0]==sums[1] && sums[1]==sums[2] && sums[2]==sums[3];
        }
        int currVal=matchsticks[index];
        boolean found=false; 
        for(int i=0; i<4; i++){
            if(currVal + sums[i] <= target){
                sums[i]+=currVal; 
                if(backtrack(index+1, matchsticks, target)){
                    return true; 
                }
                sums[i]-=currVal; 
            }
            else{
                break; 
            }
            
        }
        return false; 
        
    }
}