class Solution {
    int max;
    public int maxRepOpt1(String text) {
        this.max=0;
        Map<Character, Integer> count=new HashMap<>();
        Map<Character, Integer> longest=new HashMap<>();
        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);
            if(!count.containsKey(c)){
                count.put(c, 0);
                longest.put(c, 0);
            }
            count.put(c, count.get(c)+1);
        }
        
        for(char c: count.keySet()){
            int currCount=0;
            for(int i=0; i<text.length(); i++){
                int index=i;
                if(text.charAt(index)==c){
                    int off=0;
                    currCount=0;
                    while(index < text.length() && (text.charAt(index)==c || off<=1)){
                        if(text.charAt(index)!=c){
                            if(off==1){
                                break;
                            }
                            else{
                                off=1;
                            }
                        }
                        currCount++;
                        index++;
                    }
                    if(index==text.length() && off==0){
                        currCount++;
                    }
                    longest.put(c, Math.max(longest.get(c), currCount));
                    //i=index-1;
                    
                }
            }
            
            
        }
        //System.out.println(longest.get(text.charAt(0)));
        for(char c: count.keySet()){
            if(count.get(c)==text.length()){
                return text.length();
            }
            else if(count.get(c)==text.length()-1){
                return count.get(c);
            }
            else{
              
                max=Math.max(Math.min(count.get(c),longest.get(c)), max);

            }
            
        }
        return max;
        
       
        
    }
}