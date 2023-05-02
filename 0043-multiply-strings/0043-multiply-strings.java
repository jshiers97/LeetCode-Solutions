class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
            }
        List<Integer> output=new ArrayList<>(); 
        output.add(0); 
       
        int zeroes=0;
        
        for(int i2=num2.length()-1; i2>=0; i2--){
            List<Integer> curr=new ArrayList<>(); 
            int carry=0;
            for(int i=0; i<zeroes; i++){
                    curr.add(0, 0); 
            }
            for(int i1=num1.length()-1; i1>=0; i1--){
                
                int first=num1.charAt(i1)-'0'; 
                int second=num2.charAt(i2)-'0'; 
                int prod=(first*second) + carry;
                
                carry=prod/10;
                prod%=10;
                
                curr.add(0, prod); 
            }
            if(carry>0){
                
                curr.add(0, carry); 
            }
            
           
            
            output=add(curr, output); 
            curr=new ArrayList<>(); 
            
            
            zeroes++;
            
          
        }
        StringBuilder out=new StringBuilder(); 
        for(int i=0; i<output.size();i++){
            out.append(output.get(i));
        }
        return out.toString(); 
        
        
        
    }
    public List add(List<Integer> first, List<Integer> second){
        int carry=0;
        List<Integer> res=new ArrayList<>();
        int i1=first.size()-1;
        int i2=second.size()-1;
        while(i1>=0 && i2>=0){
            int num1=first.get(i1);
            int num2=second.get(i2);
            
            int sum=(num1+num2+carry);
            carry=(sum)/10;
            sum%=10;
            res.add(0, sum); 
            i1--;
            i2--;
        }
        while(i1>=0){
            int num1=first.get(i1);
            int sum=num1+carry;
            carry=sum/10;
            sum%=10;
            res.add(0, sum);
            i1--;
        }
        while(i2>=0){
            int num2=second.get(i2);
            int sum=num2+carry;
            carry=sum/10;
            sum%=10;
            res.add(0, sum);
            i2--;
        }
        if(carry>0){
            res.add(0, carry); 
        }
        return res; 
    }
}