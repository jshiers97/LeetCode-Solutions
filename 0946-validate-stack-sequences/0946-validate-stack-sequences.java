class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>(); 
        int index=0; 
        for(int i=0; i<popped.length; i++){
            if(stack.isEmpty() || popped[i]!=stack.peek()){
                while(index < popped.length && (stack.isEmpty() || stack.peek()!=popped[i])){
                    stack.push(pushed[index++]);
                }
                if(stack.peek()==popped[i]){
                    stack.pop(); 
                }
                else{
                    return false; 
                }
              
            }
            else if(popped[i]==stack.peek()){
                stack.pop(); 
            }
        }
        return true;
    }
}