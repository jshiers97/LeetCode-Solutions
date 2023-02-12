class Solution {
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return output; 
    }
    public void backtrack(int[] nums, int index, List<Integer> curr){
        output.add(new ArrayList<>(curr));
        
        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}