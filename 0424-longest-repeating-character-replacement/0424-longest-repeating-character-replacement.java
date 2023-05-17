class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int[] frequencyMap=new int[26];
        int maxFrequency=0;
        int longestSubstringLength=0; 
        for(int end=0; end<s.length(); end++){
            int currChar=s.charAt(end)-'A';
            frequencyMap[currChar]++;
            maxFrequency=Math.max(maxFrequency, frequencyMap[currChar]);
            boolean isValid=(end+1 - left - maxFrequency<= k);
            if(!isValid){
                int outgoingChar=s.charAt(left)-'A'; 
                frequencyMap[outgoingChar] -= 1;

                // move the start pointer forward
                left += 1;
            }
            longestSubstringLength=end+1-left; 
                
            
        }
        return longestSubstringLength;
    }
}