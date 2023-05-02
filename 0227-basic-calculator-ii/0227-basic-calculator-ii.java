class Solution {
    public int calculate(String s) {
        Stack<String> stack=new Stack<>();
        List<String> list=new ArrayList<>();
        //do * and /
        String[] arr=s.split("//s+");
        StringBuilder currNum=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c==' '){
                continue;
            }
            else if(Character.isDigit(c)){
                currNum.append(c);
            }
            else{
                list.add(currNum.toString());
                currNum=new StringBuilder();
                list.add(c+ "");
            }
        }
        list.add(currNum.toString());
        for(String x: list){
            //System.out.println(x);
        }
        List<String> l2=new ArrayList<>(); 
        //int num=Integer.parseInt(list.get(0)); 
        for(int i=0; i<list.size(); i++){
            String curr=list.get(i); 
            if(curr.equals("*")){
                int next=Integer.parseInt(list.get(i+1));
                int num=Integer.parseInt(l2.get(l2.size()-1));
                int prod=num * next;
                
                i++; 
                l2.set(l2.size()-1, prod + "");
            }
            else if(curr.equals("/")){
                int next=Integer.parseInt(list.get(i+1));
                int num=Integer.parseInt(l2.get(l2.size()-1));
                int quot=num / next;
                i++; 
                l2.set(l2.size()-1, quot + "");
            }
            else if(curr.equals("+") || curr.equals("-")){
                l2.add(curr);
            }
            else{
                l2.add(curr); 
            }
        }
        if(l2.size()==1){
            return Integer.parseInt(l2.get(0));
        }
        
        int res=Integer.parseInt(l2.get(0)); 
        for(int i=1; i<l2.size(); i++){
            String curr=l2.get(i); 
            if(curr.equals("+")){
                res+= Integer.parseInt(l2.get(i+1));
                i++; 
            }
            else{
              res-= Integer.parseInt(l2.get(i+1));
              i++;   
            }
        }
        return res; 
        
        
    }
}