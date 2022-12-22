class Solution {
    List<List<Integer>> output;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.output=new ArrayList<>();
        this.nums=nums;
        Arrays.sort(nums);
        output.add(new ArrayList<Integer>());
        for(int i=1; i<=nums.length; i++){
            backtrack(0, i, new ArrayList<Integer>());
        }
        return output; 
    }
    public void backtrack(int start, int len, List<Integer> list){
        if(list.size()==len){
            output.add(new ArrayList<Integer>(list));
            return;
        }
        for(int x=start; x<nums.length; x++){
            if(x!=start && nums[x-1]==nums[x]){
                continue;
            }
            list.add(nums[x]);
            backtrack(x+1, len, list);
            list.remove(list.size()-1);
        }
        return;
    }
}