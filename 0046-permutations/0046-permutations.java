class Solution {
    List<List<Integer>> output;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.output=new ArrayList<>();
        this.nums=nums;
        List<Integer> current=new ArrayList<>();
        for(int x: nums){
            current.add(x);
        }
        backtrack(current, 0);
        return output; 
        
    }
    public void backtrack(List<Integer> curr, int index){
        if(index==curr.size()){
            output.add(new ArrayList<>(curr));
        }
        
        for(int i=index; i<curr.size();  i++){
            Collections.swap(curr, index, i);
            backtrack(curr, index+1);
            Collections.swap(curr,index, i);
        }
        return;
    }
}