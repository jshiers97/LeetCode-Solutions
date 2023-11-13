class Solution {
    boolean two=false;
    public boolean splitString(String s) {
        return backtrack(0, s,null, 0 );
    }
    public boolean backtrack(int index, String s, Long prev, int values){
         if(index==s.length() && values>=2){
             return true;
         }
        long val=0; 
        boolean found=false;
        for(int i=index; i<s.length(); i++){
            int currVal=s.charAt(i)-'0';
            val*=10;
            val+=currVal;
            if(prev==null || val+1==prev){
                System.out.println(val); 
                found=found || backtrack(i+1, s, val, values+1); 
            }
        }
        return found; 
    }
}