class Solution {
    
    
    public int numDecodings(String s) {
        
        int[] dp=new int[s.length()];
        if(s.charAt(0)=='0'){
            if(1 < s.length() && s.charAt(1)=='0'){
                return 0; 
            }
            dp[0]=0;
        }
        else{
            dp[0]=1; 
        }
        int index=1;
        if(index < s.length() && s.charAt(index)=='0'){
            if(Character.getNumericValue(s.charAt(index-1)) > 2){ 
                return 0;
            }
            if(index+1 < s.length() && (s.charAt(index+1)=='0'  )){
                return 0; 
            }
            else{
                dp[index]=1; 
                index++; 
            }
        }
        
        
        for(int i=index; i<s.length(); i++){
            int prev= (Character.getNumericValue(s.charAt(i-1)));
            prev*=10;
            int curr=Character.getNumericValue(s.charAt(i));
            if(i+1<s.length() && s.charAt(i+1)=='0'){
                if(s.charAt(i)=='0' || curr > 2){
                    return 0; 
                }
                dp[i]=dp[i-1];
                dp[i+1]=dp[i];
                i++;
                continue;
            }
          
            else if(prev!=0 && ((prev  + curr) >=11) && ((prev + curr) <=26)  ){
                int prev1=dp[i-1];
                int prevPrev=1;
                if(i-2 >=0){
                    prevPrev=dp[i-2];
                    
                }
                dp[i]=prev1+prevPrev;
            }
            else if(curr!=0){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1]; 
    }
}