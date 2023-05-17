class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        return check(s, i, j, false); 
    }
    public boolean check(String s, int i, int j, boolean delete){
        if(i>=j){
            return true;
        }
        char c=s.charAt(i);
        char d=s.charAt(j);
        if(c==d){
            return check(s, i+1, j-1, delete);
        }
        else{
            if(delete==true){
                return false;
            }
            else{
                return check(s, i+1, j, true) || check(s, i, j-1, true);
            }
        }
    }
}