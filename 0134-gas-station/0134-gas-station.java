class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        for(int i=0; i<gas.length; i++){
            gasSum+=gas[i];
            costSum+=cost[i];
            
        }
        if(gasSum < costSum){
            return -1;
        }
        
        int currGas=0;
        int prev=-0;
        
        for(int i=0; i<gas.length; i++){
            currGas+=gas[i];
            currGas-=cost[i];
            if(currGas<0){
                prev=i+1;
                currGas=0;
            }
        }
        return currGas>=0 ? prev : -1;
    }
}