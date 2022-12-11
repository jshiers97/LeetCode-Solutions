class Solution {
    public int numSteps(String s) {
        int steps=0;
        while(!s.equals("1")){
            steps++;
            if(s.charAt(s.length()-1)=='1'){
                s=addOne(s);
            }
            else{
                s=s.substring(0, s.length()-1);
            }
        }
        return steps;
        
    }
    public String addOne(String s){
        StringBuilder output=new StringBuilder(); 
        output.append(s);
        int carry=1;
        for(int i=output.length()-1; i>=0; i--){
            char c=output.charAt(i);
            if(c=='0'){
                output.setCharAt(i, '1');
                carry=0;
                break;
            }
            else{
                output.setCharAt(i, '0');
            }
        }
        if(carry==1){
            output.insert(0, '1');
        }
        return output.toString(); 
    }
}