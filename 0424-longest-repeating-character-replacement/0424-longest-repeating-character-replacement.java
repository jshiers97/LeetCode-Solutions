class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map=new HashMap<>(); 
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i); 
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
        }
        for(char c: map.keySet()){
            int left=0;
            int right=0;
            int curr=0;
            int off=0;
            while(right<s.length()){
                if(s.charAt(right)==c){
                    right++;
                    curr++;
                }
                else{
                    right++;
                    off++;
                    curr++;
                }
                while(off>k){
                    char d=s.charAt(left);
                    if(d!=c){
                        off--;
                    }
                    curr--;
                    left++;
                }
                map.put(c, Math.max(map.get(c), curr)); 
                
            }
        }
        int max=0;
         for(char c: map.keySet()){
             max=Math.max(max, map.get(c));
         }
        return max; 
    }
}