class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longest=0;
        int left=0;
        int right=0;
        Map<Character, Integer> map=new HashMap<>(); 
        int unique=0;
        while(right < s.length()){
            char c=s.charAt(right++);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                map.put(c, map.get(c)+1);
            }
            if(map.get(c)==1){
                unique++;
                while(unique>k && left < s.length()){
                    char d=s.charAt(left++);
                    map.put(d, map.get(d)-1);
                    if(map.get(d)==0){
                        unique--; 
                    }
                }
                 longest=Math.max(longest, right-left);
            }
            else{
                longest=Math.max(longest, right-left);
            }
        }
        return longest;
    }
}