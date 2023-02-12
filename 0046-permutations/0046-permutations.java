class Solution {
    List<List<Integer>> output;
    int[] nums;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        this.output=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        for(int x: nums){
            curr.add(x);
        }
        backtrack(curr, 0);
        return output; 
    }
    public void backtrack(List<Integer> curr, int index){
        if(index==nums.length){
            output.add(new ArrayList<>(curr));
        }
        
        for(int i=index; i<nums.length; i++){
    
            Collections.swap(curr, index, i);
            backtrack(curr, index+1);
            Collections.swap(curr, index, i);
        }
    }
}