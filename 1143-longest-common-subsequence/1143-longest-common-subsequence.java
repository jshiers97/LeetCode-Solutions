class Solution {
    int[][] dp;
    String text1;
    String text2; 
    public int longestCommonSubsequence(String text1, String text2) {
        this.dp=new int[text1.length()+1][text2.length()+1];
        this.text1=text1;
        this.text2=text2; 
        
        for(int i=text1.length()-1; i>=0; i--){
            for(int j=text2.length()-1; j>=0; j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]); 
                }
            }
        }
        return dp[0][0];
    }
    
}