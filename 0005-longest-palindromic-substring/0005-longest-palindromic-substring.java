class Solution {
    int max; 
    int start;
    int end; 
    public String longestPalindrome(String s) {
        this.max=0;
        this.start=0;
        this.end=0; 
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                max=Math.max(typeTwo(s, i), max); 
            }
            if(i+1 < s.length() && s.charAt(i-1)==s.charAt(i+1)){
                max=Math.max(typeOne(s, i), max);
            }
        }
        return s.substring(start, end+1); 
        
    }
    public int typeOne(String s, int index){
        int temp=3; 
        int first=index-1;
        int second=index+1;
        while(first >=0 && second<s.length() && s.charAt(first)==s.charAt(second)){
            first--;
            second++;
            
        }
        temp= (second - first) -1; 
        System.out.println(temp); 
        if(temp > max){
            start=first+1;
            end=second-1; 
        }
        return temp; 
    }
    public int typeTwo(String s, int index){
        int temp=2; 
        int first=index-1;
        int second=index; 
        while(first >=0 && second<s.length() && s.charAt(first)==s.charAt(second)){
            first--;
            second++;
            
        }
        temp= (second - first) -1; 
         if(temp > max){
            start=first+1;
            end=second-1; 
        }
        return temp; 
    }
}