class Solution {
    public int minDeletions(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        Set<Integer> freq=new HashSet<>();
        int total=0; 
        for(int i=0; i<26; i++){
            if(chars[i]>0 && freq.contains(chars[i])){
                while(chars[i]>0 && freq.contains(chars[i])){
                    chars[i]--;
                    total++; 
                }

                
            }
            freq.add(chars[i]);
        }
        return total; 
        
    }
     
        
}
