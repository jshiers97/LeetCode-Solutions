class Solution {
    public int minCost(String colors, int[] neededTime) {
        int min=0;
        char prev=colors.charAt(0);
        int prevI=0;
        
        for(int i=1; i<colors.length(); i++){
            char curr=colors.charAt(i);
            if(curr==prev){
                System.out.println(i);
                if(neededTime[i] >= neededTime[prevI]){
                    min+=neededTime[prevI];
                    prevI=i;
                }
                else{
                    min+=neededTime[i];
                }
            }
            else{
                prev=colors.charAt(i);
                prevI=i;
            }
            
        }
        return min;
    }
    
}