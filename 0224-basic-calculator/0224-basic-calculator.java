class Solution {
    int index=0;
    int res=0;
    public int calculate(String s) {
        return calc(s);
    }
    
    public int calc(String s){
        int sum=0;
        int operator=1;
        
        while(index<s.length()){
            char c=s.charAt(index);
            if(c==')'){
                index++;
                break;
            }
            else if(c=='('){
                index++;
                sum+= calc(s) * operator;
            }
            else if(c==' '){
                index++;
            }
            else if(c=='+'){
                operator=1;
                index++;
            }
            else if(c=='-'){
                operator=-1;
                index++;
            }
            else{
                StringBuilder curr=new StringBuilder();
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    curr.append(s.charAt(index++));
                }
                //index--;
                sum+= Integer.parseInt(curr.toString()) * operator;
               
            }

        }
        return sum; 
    }
}