class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int t1_cost=Integer.MAX_VALUE;
        int t2_cost=Integer.MAX_VALUE;
        int t1_prof=0;
        int t2_prof=0; 
        
        for(int i=0; i<prices.length; i++){
            t1_cost=Math.min(t1_cost, prices[i]);
            t1_prof=Math.max(t1_prof, prices[i]-t1_cost); 
            t2_cost=Math.min(t2_cost, prices[i]-t1_prof);
            t2_prof=Math.max(t2_prof, prices[i]-t2_cost); 
        }
        return t2_prof; 
    }
}