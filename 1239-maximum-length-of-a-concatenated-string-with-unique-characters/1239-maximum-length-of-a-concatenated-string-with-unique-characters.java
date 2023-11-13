class Solution {
    int max=0; 
    public int maxLength(List<String> arr) {
        List<String> replace=new ArrayList<>(); 
        for(String str: arr){
            Set<Character> seen=new HashSet<>();
            boolean add=true;
            for(char c: str.toCharArray()){
                if(seen.contains(c)){
                    add=false;
                    break;
                }
                else{
                    seen.add(c);
                }
            }
            if(add){
                replace.add(str);
            }
        }
        backtrack(0, replace, "", new HashSet<>());
        return max; 
    }
    public void backtrack(int index, List<String> arr, String curr, Set<Character> seen){
        if(index==arr.size()){
            return; 
        }
        for(int i=index; i<arr.size(); i++){
            String insert=arr.get(i); 
            boolean contains=false;
            for(char c: insert.toCharArray()){
                if(seen.contains(c)){
                    contains=true;
                    break;
                }
            }
            if(!contains){
                max=Math.max(max, curr.length() + insert.length());
                Set<Character> replace=new HashSet<>(seen);
                for(char c: insert.toCharArray()){
                    replace.add(c);
                }
                backtrack(i+1, arr, curr+insert, replace);
            }
        }
    }
}