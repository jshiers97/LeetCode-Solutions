class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>(); 
        for(String str: tokens){
            if(str.equals("+")){
                int first=stack.pop();
                int second=stack.pop();
                stack.push(first+second); 
            }
            else if(str.equals("-")){
                int first=stack.pop();
                int second=stack.pop();
                stack.push(second-first); 
            }
            else if(str.equals("/")){
                int first=stack.pop();
                int second=stack.pop();
                stack.push(second/first); 
            }
            else if(str.equals("*")){
                int first=stack.pop();
                int second=stack.pop();
                stack.push(second*first); 
            }
            else{
                stack.push(Integer.parseInt(str)); 
            }
        }
        return stack.pop(); 
    }
}