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
        
        for(String dir: stack){
            output.append("/");
            output.append(dir);
            
        }
        if(output.length()==0){
            return "/";
        }
        //output.reverse();
        return output.toString(); 
        
        
    }
}