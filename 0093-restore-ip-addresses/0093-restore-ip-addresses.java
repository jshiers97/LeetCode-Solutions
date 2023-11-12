class Solution {
    List<String> res=new ArrayList<>(); 
    public List<String> restoreIpAddresses(String s) {
        backtrack(0, s, new StringBuilder(), 0);
        return res;
    }
    public void backtrack(int index, String s, StringBuilder curr, int sections){
        if(index==s.length() ){
            if(sections==4){
                res.add(curr.toString());
            }
            
            return;
        }
        if(sections>=4){
            return;
        }
        int currVal=0;
        for(int i=index; i<s.length(); i++){
            int x=s.charAt(i) -'0';
            if(x==0 && currVal == 0){
                StringBuilder insert=new StringBuilder(curr);
                insert.append(currVal);
                if(sections<3){
                    insert.append(".");
                }
                backtrack(i+1, s, insert, sections+1);
                break;
            }
            currVal*=10;
            currVal+=x;
            if(currVal <=255){
                StringBuilder insert=new StringBuilder(curr);
                insert.append(currVal);
                if(sections<3){
                    insert.append(".");
                }
                
                System.out.println(insert.toString() );
                System.out.println(sections); 
                backtrack(i+1, s, insert, sections+1);
            }
            else{
                break;
            }
            
        }
        
    }
}