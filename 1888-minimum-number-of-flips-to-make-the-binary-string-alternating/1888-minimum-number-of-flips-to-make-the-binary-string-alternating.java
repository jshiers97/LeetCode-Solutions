class Solution {
    public int minFlips(String s) {
        //String oneStart="";
        boolean one=true;
        //String zeroStart=""; 
        String temp= s + s; 
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<temp.length();i++)
        {
            if(i%2==0) sb1.append("0");
            else sb1.append("1");
            if(i%2==1) sb2.append("0");
            else sb2.append("1");
        }
        String oneStart=sb1.toString();
        String zeroStart=sb2.toString();
        
        //oneStart=oneStart + oneStart;
        //zeroStart=zeroStart + zeroStart;
        
        int min=Integer.MAX_VALUE;
        int left=0; 
        int right=s.length(); 
        int len=s.length(); 
        int curr1=0;
        int curr2=0; 
        for(int i=0; i<len; i++){
            if(temp.charAt(i)!=oneStart.charAt(i)){
                curr1++;
            }
            if(temp.charAt(i)!=zeroStart.charAt(i)){
                curr2++;
            }
        }
        min=Math.min(curr1, curr2); 
        
        while(right<temp.length()){
            if(temp.charAt(left)!=oneStart.charAt(left)){
                curr1--;
            }
            if(temp.charAt(left)!=zeroStart.charAt(left)){
                curr2--;
            }
            left++;
            if(temp.charAt(right)!=oneStart.charAt(right)){
                curr1++;
            }
            if(temp.charAt(right)!=zeroStart.charAt(right)){
                curr2++;
            }
            right++;
            int tempMin=Math.min(curr1, curr2);
            min=Math.min(tempMin, min); 
        }
        return min; 
    }
}