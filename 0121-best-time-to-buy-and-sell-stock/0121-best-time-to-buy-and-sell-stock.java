class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        
        int prof=0;
        for(int i=1; i<prices.length; i++){
            prof=Math.max(prof, prices[i]-min);
            min=Math.min(prices[i], min);
        }
        return prof>0 ? prof : 0;
    }
}