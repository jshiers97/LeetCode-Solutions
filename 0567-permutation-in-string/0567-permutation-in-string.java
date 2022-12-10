class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int left=0;
        int right=0;
        int[] original=new int[26];
        for(char c: s1.toCharArray()){
            original[c-'a']++;
        }
        int[] chars=new int[26];
        for(int i=0; i<s1.length(); i++){
            char c=s2.charAt(right++);
            chars[c-'a']++;
        }
        //System.out.println(right);
        while(right < s2.length()){
            if(equals(chars, original)){
                return true;
            }
            char c=s2.charAt(left++);
            chars[c-'a']--;
            char d=s2.charAt(right++);
            chars[d-'a']++; 
        }
        return equals(chars, original);
        
    }
    public boolean equals(int[] char1, int[] char2){
        for(int i=0; i<26; i++){
            if(char1[i]!=char2[i]){
                return false;
            }
        }
        return true; 
    }
}