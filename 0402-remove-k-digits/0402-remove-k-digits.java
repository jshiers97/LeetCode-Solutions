class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack=new Stack<>();
        int count=0;
        for(int i=0; i<num.length(); i++){
            int x=Character.getNumericValue(num.charAt(i));
            while(k> 0 && stack.size() > 0 && stack.peek() > x){
               
                k-=1;
                stack.pop();
            }
            stack.push(x);
        }
        
        for(int i=0; i<k; i++){
            stack.pop();
        }
        
        StringBuilder output=new StringBuilder();
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        StringBuilder reverse=output.reverse();
        if(reverse.length()==0){
            return "0";
        }
        while(reverse.length() > 0 && reverse.charAt(0)=='0' ){
            reverse.delete(0, 1);
        }
        if(reverse.length()==0){
            return "0";
        }
        return reverse.toString();
        
        
        
    }
}