class Solution {
    Set<String> seen=new HashSet<>(); 
    String res;
    public String findDifferentBinaryString(String[] nums) {
        for(String x: nums){
            seen.add(x); 
        }
        backtrack(0, nums.length, "");
        return res; 
                                                            
                                                
    }
    public void backtrack(int index, int n, String curr){
        if(index==n){
            if(!seen.contains(curr)){
                 res=curr;
            }
            return;
        }
        String temp1=curr + "0";
        String temp2=curr+ "1";
        backtrack(index+1, n, temp1);
        backtrack(index+1, n, temp2); 
        return; 
        
    }
}