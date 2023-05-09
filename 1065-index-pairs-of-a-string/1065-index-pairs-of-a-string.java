class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> out=new ArrayList<>(); 
        
        Set<String> set=new HashSet<>();
        for(String str: words){
            set.add(str); 
        }
        for(int i=0; i<text.length(); i++){
            for(int j=i; j<text.length(); j++){
                String sub=text.substring(i, j+1);
                if(set.contains(sub)){
                    out.add(new int[]{ i, j});
                }
            }
        }
        int[][] output=new int[out.size()][2];
        for(int i=0; i<out.size(); i++){
            output[i]=out.get(i); 
        }
        return output; 
    }
}