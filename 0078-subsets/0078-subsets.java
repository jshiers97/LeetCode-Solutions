class Solution {
    
    List<List<Integer>> output;
    public List<List<Integer>> subsets(int[] nums) {
        this.output=new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return output; 
        
    }
    public void backtrack(int[] nums, List<Integer> curr, int index ){
        output.add(new ArrayList<>(curr));
        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
            
        
        
    }
}