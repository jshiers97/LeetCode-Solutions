class Solution {
    public int maximumSwap(int num) {
        StringBuilder currr=new StringBuilder(); 
        currr.append(num); 
        String temp=currr.toString(); 
        for(int i=0; i<temp.length(); i++){
            
            int curr=Character.getNumericValue(temp.charAt(i)); 
            int max=curr;
            int index=-1; 
            for(int j=i+1; j<temp.length(); j++){
                int next=Character.getNumericValue(temp.charAt(j));
                if(next > max || (next==max && index>-1) ){
                    max=next;
                    index=j; 
                }
                    
                
            }
            if(index>-1){
                return swap(temp, i, index); 
            }
        }
        return Integer.parseInt(temp); 
    }
    public int swap(String curr, int i, int j){
        StringBuilder temp=new StringBuilder(); 
        temp.append(curr); 
        char c=temp.charAt(i); 
        temp.setCharAt(i, temp.charAt(j)); 
        temp.setCharAt(j, c); 
        return Integer.parseInt(temp.toString());
    }
}