class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack=new Stack<>(); 
        StringBuilder res=new StringBuilder(s); 
        for(int i=0; i<res.length(); i++){
            if(i==0 || res.charAt(i)!=res.charAt(i-1)){
                stack.push(1); 
            }
            else{
                int prev=stack.pop();
                stack.push(prev+1); 
                if(stack.peek()==k){
                    stack.pop();
                    res.delete(i-k+1, i+1);
                    i=i-k;
                }
                
            }
        }
        return res.toString(); 
    }
}