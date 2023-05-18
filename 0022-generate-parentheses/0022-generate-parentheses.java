class Solution {
    List<String> output;
    public List<String> generateParenthesis(int n) {
        this.output=new ArrayList<>();
        generate(0, 0, n, "");
        return output; 
    }
    public void generate(int open, int close, int n, String curr){
        if(close==n){
            output.add(new String(curr));
            return;
        }
        if(open<n){
            generate(open+1, close, n, curr+"(");
        }
        if(close < open){
            generate(open, close+1, n, curr+")");
        }
        return;
    }
}