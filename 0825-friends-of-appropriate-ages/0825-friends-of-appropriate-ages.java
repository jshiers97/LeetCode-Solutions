class Solution {
    public int numFriendRequests(int[] ages) {
        
        Arrays.sort(ages); 
        int count=0; 
        for(int i=ages.length-1; i>=0; i--){
            //int min=Integer.MAX_VALUE;
            int max=ages[i];
            int min=ages[i]/2 + 8;
            if(min > max){
                continue;
            }
            for(int j=i-1; j>=0; j--){
                if(ages[j]==ages[i]){
                    count+=2;
                }
                else if(ages[j] >=min && ages[j]<=max){
                    count++; 
                }
                else{
                    break;
                }
            }
            
        }
        return count; 
    }
}