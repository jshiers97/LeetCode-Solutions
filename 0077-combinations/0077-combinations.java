class Solution {
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k, new ArrayList<>());
        return output; 
    }
    public void backtrack(int n, int i, int k, List<Integer> curr){
        if(curr.size()==k){
            output.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() > k){
            return;
        }
        for(int x=i; x<=n; x++){
            curr.add(x);
            backtrack(n, x+1, k, curr);
            curr.remove(curr.size()-1);
        }
        return;
    }
}