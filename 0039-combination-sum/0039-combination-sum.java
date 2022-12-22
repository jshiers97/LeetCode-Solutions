class Solution {
    List<List<Integer>> output;
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.output=new ArrayList<>();
        this.candidates=candidates;
        this.target=target;
        backtrack(new ArrayList<>(), 0, 0);
        return output; 
        
    }
    public void backtrack(List<Integer> curr, int index, int currSum){
        if(index >= candidates.length || currSum > target ){
            return;
        }
        if(currSum==target){
            output.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            
            curr.add(candidates[i]);
            backtrack(curr , i, currSum+candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}