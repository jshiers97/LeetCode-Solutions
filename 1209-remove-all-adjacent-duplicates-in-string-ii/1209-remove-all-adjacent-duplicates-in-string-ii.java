class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder res=new StringBuilder(s); 
        Stack<Integer> stack=new Stack<>(); 
        stack.push(1);
        //int prev=0; 
        for(int i=0; i<res.length(); i++){
            if(i==0){
                stack.push(1);
            }
            // char c=s.charAt(i);
            // char prevChar=s.charAt(i-1);
            else if(res.charAt(i)==res.charAt(i-1)){
                int temp=stack.pop();
                stack.push(temp+1);
                if(stack.peek()==k){
                    stack.pop(); 
                    res.delete(i-k+1, i+1);
                    i=i-k;
                }
            }
            else{
                stack.push(1);
                //prev=i; 
            }
        }
        return res.toString();
        
    }
}