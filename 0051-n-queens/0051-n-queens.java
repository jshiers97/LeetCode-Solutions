class Solution {
    List<List<String>> output=new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        
        backtrack(n, 0, new ArrayList<>(), 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return output; 
    }
    public void backtrack(int n, int count, List<String> curr, int currRow, Set<Integer> cols, Set<Integer> diag, Set<Integer> anti){
        if(count==n){
            output.add(new ArrayList<>(curr));
            return;
        }
        if(currRow==n){
            return;
        }
        StringBuilder r=new StringBuilder();
        for(int i=0; i<n; i++){
            r.append(".");
        }
        for(int i=0; i<n; i++){
            int diagonalVal= i + currRow;
            int antiVal= i - currRow;
            if(!cols.contains(i) && !diag.contains(diagonalVal) && !anti.contains(antiVal) ){
                cols.add(i);
                diag.add(diagonalVal);
                anti.add(antiVal);
                r.setCharAt(i, 'Q');
                curr.add(r.toString());
                backtrack(n, count+1, curr, currRow+1, cols, diag, anti );
                cols.remove(i);
                diag.remove(diagonalVal);
                anti.remove(antiVal);
                r.setCharAt(i, '.');
                curr.remove(curr.size()-1);
                
                
            }
        }
        
    }
}