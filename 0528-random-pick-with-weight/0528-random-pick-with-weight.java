class Solution {

    int sum=0;
    List<Integer> list;
    int[] w;
    public Solution(int[] w) {
        this.w=w;
        this.list=new ArrayList<>();
        for(int x: w){
            sum+=x;
        }
        int prev=0;
        for(int i=0; i<w.length; i++){
            list.add(prev+w[i]);
            prev+=w[i];
        }
    }
    
    public int pickIndex() {
        int rand=(int)(Math.random() * sum);
        
        for(int i=0; i<list.size(); i++){
            if(rand < list.get(i)){
                return i;
            }
        }
        return rand;
        

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */