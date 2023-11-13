class Solution {
    List<List<String>> res=new ArrayList<>(); 
    int n;
    String copy;
    int result=0; 
    public int totalNQueens(int n) {
        this.n=n;
        StringBuilder temp=new StringBuilder();
        for(int i=0; i<n; i++){
            temp.append(".");
        }
        this.copy=temp.toString(); 
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>()); 
        return result;
    }
    public void backtrack(int row, Set<Integer> col, Set<Integer> diag, Set<Integer> antiDiag){
        if(row==n){
            result++;
            return; 
        }
        //String insert=new 
        for(int i=0; i<n; i++){
            int diagonal=i-row; 
            int antiDiagonal=i+row; 
            if(!col.contains(i) && !diag.contains(diagonal) && !antiDiag.contains(antiDiagonal)){
                
               
                col.add(i);
                diag.add(diagonal);
                antiDiag.add(antiDiagonal); 
                backtrack(row+1, col, diag, antiDiag); 
               
                col.remove(i);
                diag.remove(diagonal);
                antiDiag.remove(antiDiagonal); 
            }
        }
    }
}