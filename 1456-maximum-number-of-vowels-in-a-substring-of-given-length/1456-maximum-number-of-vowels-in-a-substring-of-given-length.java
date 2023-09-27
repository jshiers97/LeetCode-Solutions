class Solution {
    public int maxVowels(String s, int k) {
        int max=0; 
        int left=0; 
        int right=0; 
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count=0; 
        for(int i=0; i<k; i++){
            char c=s.charAt(i);
            if(vowels.contains(c)){
                count++; 
            }
        }
        right=k; 
        max=Math.max(max, count); 
        while(right < s.length()){
            char c=s.charAt(right++);
            if(vowels.contains(c)){
                count++;
            }
            char d=s.charAt(left++);
            if(vowels.contains(d)){
                count--; 
            }
            max=Math.max(max, count); 
        }
        return max; 
    }
}