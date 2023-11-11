class Solution {
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target, 0, new ArrayList<>());
        return output; 
    }
    public void backtrack(int index, int[] candidates, int target, int currSum, List<Integer> curr){
        if(currSum==target){
            output.add(new ArrayList<>(curr));
            return;
        }
        if(index==candidates.length){
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]+currSum <=target){
                curr.add(candidates[i]);
                backtrack(i+1, candidates, target, currSum+candidates[i], curr);
                curr.remove(curr.size()-1);
            }
            else{
                return;
            }
        }
        
    }
}