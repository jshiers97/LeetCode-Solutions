class Solution {
    public String parseTernary(String expression) {
        StringBuilder str=new StringBuilder();
        str.append(expression); 
        
        while(str.length() > 1){
            int question=0;
            int colon=0;
            for(int i=1; i<str.length(); i++){
                char c=str.charAt(i);
                if(c=='?'){
                    question++;
                }
                else if(c==':'){
                    colon++;
                }
               
                if(question==colon){
                    String temp;
                    if(str.charAt(0)=='T'){
                        temp=str.substring(2, i);
                        
                    }
                    else{
                        temp=str.substring(i+1);
                       
                    }
                    str=new StringBuilder();
                    str.append(temp);
                    break;
                   
                }
            }
        }
        return str.toString(); 
    }
}