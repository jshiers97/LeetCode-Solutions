class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        this.memo=new Boolean[s.length()+1][p.length()+1];
        
        return dp(s,0 ,p,0);
    }
    public boolean dp(String s, int first, String p, int second){
        if(s.length()==first){
            if(second==p.length()){
                return true;
            }
            while(second < p.length() && p.charAt(second)=='*'){
                second++;
            }
            return second==p.length();
        }
        if(p.length()==second){
            return false;
        }
        if(memo[first][second]!=null){
            return memo[first][second];
        }
        Boolean res;
        char c=s.charAt(first);
        char d=p.charAt(second);
        if(c==d){
            res=dp(s, first+1, p, second+1);
        }
        else if(d=='*'){
            res=dp(s, first+1, p, second+1) || dp(s, first+1, p, second) || dp(s, first, p, second+1);
        }
        else if(d=='?'){
            res=dp(s, first+1, p, second+1);
        }
        else{
            res=false;
        }
        memo[first][second]=res;
        return res;
    }
}