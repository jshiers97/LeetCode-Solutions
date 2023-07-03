class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<>(); 
        Set<String> res=new HashSet<>(); 
        int left=0; 
        int right=9; 
        while(right < s.length()){
            String sub=s.substring(left, right+1); 
            //System.out.println(sub); 
            if(set.contains(sub)){
                res.add(sub); 
            }
            else{
                set.add(sub); 
            }
            right++;
            left++; 
        }
        List<String> output=new ArrayList<>(); 
        for(String str: res){
            output.add(str); 
        }
        return output; 
    }
}