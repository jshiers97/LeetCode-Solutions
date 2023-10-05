class Solution {
    public String simplifyPath(String path) {
        String[] paths=path.split("\\/+");
        
        Stack<String> stack=new Stack<>();
        for(int i=0; i<paths.length; i++){
            String curr=paths[i];
            if(curr==null || curr.length()==0 || curr.equals(".")){
                continue;
            }
            
            if(curr.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop(); 
                }
            }
            else{
                stack.push(curr); 
            }
               
        }
        StringBuilder str=new StringBuilder(); 
        
        while(!stack.isEmpty()){
            str.insert(0, stack.pop());
            str.insert(0, "/");
            
            
        }
        if(str.length()==0){
            return "/";
        }
        return str.toString();
    }
}