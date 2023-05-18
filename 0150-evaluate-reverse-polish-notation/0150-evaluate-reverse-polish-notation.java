class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(String str: tokens){
            if(str.equals("+") || str.equals("-")){
                int second=Integer.parseInt(stack.pop());
                int first=Integer.parseInt(stack.pop());
                if(str.equals("+")){
                    stack.push((first+second) + "");
                }
                else{
                    stack.push((first-second) + "");
                }
                
            }
            else if(str.equals("/") || str.equals("*")){
                int second=Integer.parseInt(stack.pop());
                int first=Integer.parseInt(stack.pop());
                if(str.equals("*")){
                    stack.push((first*second) + "");
                }
                else{
                    stack.push((first/second) + "");
                }
            }
            else{
                stack.push(str); 
            }
        }
        return Integer.parseInt(stack.pop());
    }
}