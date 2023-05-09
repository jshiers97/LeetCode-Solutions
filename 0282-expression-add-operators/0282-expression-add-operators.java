class Solution {
    List<String> output;
    int target;
    String num;
    public List<String> addOperators(String num, int target) {
        this.output=new ArrayList<>();
        this.target=target;
        this.num=num;
        backtrack(0, 0, 0, "");
        
        
        return output; 
    }
    public void backtrack(int index, long currVal, long prevVal, String curr){
        if(index==num.length() && currVal==target){
            output.add(new String(curr));
            return;
        }
        if(index>num.length()){
            return;
        }
        for(int i=index; i<num.length(); i++){
            long val;
            if(i>index && num.charAt(index)=='0'){
                continue;
            }
            else{
                val=Long.valueOf(num.substring(index, i+1));
            }
            if(curr.length()==0){
                backtrack(i+1, val, val, val + "");
            }
            else{
                String add=curr+ "+" + val;
                backtrack(i+1, currVal + val, val, add);
                String del=curr + "-" + val;
                backtrack(i+1, currVal-val, -val, del);
                String mult=curr + "*" + val;
                backtrack(i+1, (currVal-prevVal) + (prevVal * val), prevVal*val, mult);
            }
             
        }
    }
}