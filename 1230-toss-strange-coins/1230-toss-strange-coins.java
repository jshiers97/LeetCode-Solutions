class Solution {
    double[][] memo;
    public double probabilityOfHeads(double[] prob, int target) {
        this.memo=new double[prob.length][target+1];
        for(double[] arr: memo){
            Arrays.fill(arr, -1.0); 
        }
        return rec(prob, target, 0);
    }
    public double rec(double[] prob, int target, int index){
        if(target<0){
            return 0; 
        }
        if (index == prob.length) {
            return target == 0 ? 1 : 0;
        }
        if(memo[index][target]!=-1){
            return memo[index][target];
        }
        
        double head=prob[index] * rec(prob, target-1, index+1);
        double tail=(1-prob[index]) * rec(prob, target, index+1); 
        memo[index][target]=head + tail ;
        return memo[index][target];
        
    }
}