class Solution {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>(); 
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i); 
            if(c==']'){
                StringBuilder toMult=new StringBuilder();
                
                while(stack.peek() != '['){
                    toMult.insert(0, stack.pop()); 
                }
                stack.pop(); 
                StringBuilder mult=new StringBuilder(); 
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    mult.insert(0, stack.pop()); 
                }
                int iter=Integer.parseInt(mult.toString()); 
                String res=toMult.toString(); 
                
                for(int j=0; j<iter-1; j++){
                    res+=toMult.toString(); 
                }
                
                for(char d: res.toCharArray()){
                    stack.push(d); 
                }
                
            }
            else{
                stack.push(c); 
            }
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop()); 
        }
        return result.toString(); 
    }
}