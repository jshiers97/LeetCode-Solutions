class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()];
        int min=Integer.MAX_VALUE;
        for(String str: wordDict){
            min=Math.min(min, str.length()); 
        }
        for(int i=min-1; i<s.length(); i++){
            for(String str: wordDict){
                int len=str.length(); 
                if(i-len < -1){
                    continue;
                }
                if(i-len==-1 || dp[i-len] ){
                    if(str.equals(s.substring(i-len+1, i+1))){
                        dp[i]=true; 
                    }
                    
                }
            }
        }
        return dp[s.length()-1];
    }
}