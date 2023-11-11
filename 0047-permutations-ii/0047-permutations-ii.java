class Solution {
    Set<List<Integer>> set=new HashSet<>(); 
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        for(int x: nums){
            temp.add(x); 
        }
        backtrack(0, nums, temp);
        List<List<Integer>> res=new ArrayList<>(); 
        for(List<Integer> l: set){
            res.add(l); 
        }
        return res;
    }
    public void backtrack(int index, int[] nums, List<Integer> curr){
        set.add(new ArrayList<>(curr)); 
        if(index==nums.length){
            return;
        }
        for(int i=index; i<nums.length; i++){
            Collections.swap(curr, i, index);
            backtrack(index+1, nums, curr);
            Collections.swap(curr, i, index);
        }
    }
}