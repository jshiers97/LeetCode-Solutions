class Solution {
    List<List<String>> output=new ArrayList<>(); 
    
    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return output; 
    }
    public boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1; 
        while(left<right){
            char x=s.charAt(left);
            char y=s.charAt(right);
            if(x!= y){
                return false;
            }
            left++;
            right--; 
        }
        return true;
    }
    
    public void backtrack(int index, String s, List<String> list){
        if(index==s.length()){
            output.add(new ArrayList<>(list));
            return; 
        }
        
        StringBuilder curr=new StringBuilder(); 
        for(int i=index; i<s.length(); i++){
            char c=s.charAt(i);
            curr.append(c);
            if(isPalindrome(curr.toString())){
                List<String> temp=new ArrayList<>(list);
                temp.add(curr.toString());
                backtrack(i+1, s, temp);
            }
            
        }
    }
}