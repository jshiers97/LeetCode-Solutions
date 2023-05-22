class Solution {
    int m;
    int n; 
    String s1;
    String s2;
    String s3; 
    boolean found=false;
    int dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        this.m=s1.length();
        this.n=s2.length(); 
        if(m+n != s3.length()){
            return false; 
        }
        if(s1.equals("")){
            return s2.equals(s3);
        }
        if(s2.equals("")){
            return s1.equals(s3);
        }
        
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.dp=new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1); 
        }
        return recurse(0, 0);
       
        
    }
    public boolean recurse(int first, int second){
        if (first == s1.length()) {
            return s2.substring(second).equals(s3.substring(first + second));
        }
        if (second == s2.length()) {
            return s1.substring(first).equals(s3.substring(first + second));
        }
        if(dp[first][second] >=0){
            return dp[first][second]==1; 
        }
        boolean f=false;
        boolean s=false;
       
        if (s1.charAt(first) == s3.charAt(first + second) && s2.charAt(second) == s3.charAt(first + second)) {
            f = recurse(first + 1, second) || recurse(first, second + 1);
        } else if (s1.charAt(first) == s3.charAt(first + second)) {
            f = recurse(first + 1, second);
        } else if (s2.charAt(second) == s3.charAt(first + second)) {
            s = recurse(first, second + 1);
        }
 
        boolean ans=f||s;
        dp[first][second]= ans ? 1 : 0; 
        return ans;
    }
}