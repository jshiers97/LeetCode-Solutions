class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length(); 
        int n=str2.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0]=0;
        }
        for(int j=0; j<=n; j++){
            dp[0][j]=0;
        }
        
        //fill the rest of the array by checking if the current chars of s1 and s2 match or not
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                j--;
                i--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        // if there are any remaining characters in either str1 or str2,
        // we need to add them to the supersequence
        while (i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        return sb.reverse().toString(); 
        
        
    }
}