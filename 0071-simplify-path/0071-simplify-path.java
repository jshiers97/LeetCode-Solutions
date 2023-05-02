class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String str: parts){
            //String str=parts[i];
            if(str.equals("")){
                continue;
            }
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(str.equals(".")){
                continue;
            }
            else{
                stack.push(str);
            }
        }
        StringBuilder output=new StringBuilder(); 
        
        while(!stack.isEmpty()){
            
            output.insert(0, stack.pop());
            output.insert(0, "/");
            
            
        
        }
        if(output.length()==0){
            return "/";
        }
        //output.reverse();
        return output.toString(); 
        
        
    }
}