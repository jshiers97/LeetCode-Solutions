class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)){
            return s; 
        }
        if(s.length() < t.length()){
            return "";
        }
        int[] needed=new int[128];
        int needCount=0;
        for(char c: t.toCharArray()){
            needed[c-'A']++;
            if(needed[c-'A']==1){
                needCount++;
            }
        }
        int left=0;
        int[] have=new int[128];
        int right=0; 
        int min=Integer.MAX_VALUE;
        int haveCount=0; 
        String res="";
        while(right < s.length()){
            char c=s.charAt(right); 
            
            have[c-'A']++;
            if(have[c-'A']==needed[c-'A']){
                haveCount++;
            }
            
            while(haveCount==needCount){
               
                
                if(min > right-left+1){
                   
                    min=right-left+1;
                    res=s.substring(left, right+1); 
                }
             
                char d=s.charAt(left++);
                have[d-'A']--;
                if(have[d-'A']+1 == needed[d-'A'] && needed[d-'A']>0){
                    haveCount--; 
                }
                
            }
            right++; 
            
        }
        return res; 
        
    }
}