class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum=0;
        for(int x: cardPoints){
            totalSum+=x; 
        }
        if(k>=cardPoints.length){
            return totalSum; 
        } 
        int answer=0; 
        int left=0; 
        int right=cardPoints.length-k-1; 
       
        int currSum=0; 
        for(int i=0; i<=right; i++){
            currSum+=cardPoints[i];
        }
      
        
       
        answer=totalSum-currSum; 
        currSum-=cardPoints[right];
        
        while(right < cardPoints.length){
            currSum+=cardPoints[right];
            answer=Math.max(answer, totalSum-currSum); 
            currSum-=cardPoints[left++];
            right++; 
           
            
            
        }
        return answer; 
    }
}