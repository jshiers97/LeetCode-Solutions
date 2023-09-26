class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int longest=0; 
        int res=0; 
        Map<Character, Integer> map=new HashMap<>(); 
        while(right < s.length()){
            char c=s.charAt(right);
            int val=map.getOrDefault(c, 0);
            map.put(c, val+1); 
            longest=Math.max(longest, map.get(c)); 
            
            while((right-left +1 ) - longest > k){
                int temp=map.get(s.charAt(left));
                map.put(s.charAt(left), temp-1);
                left++; 
            }
            res=Math.max(res, right-left+1); 
            right++; 
            
        }
        return res; 
    }
}