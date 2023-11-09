class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //first we will sort by increasing capital
        //then, based on starting w, we will add all projects whose capital we can afford to a priorityqueue sorted by profit
        // do one with most profit,
        //continue
        
        //System.out.println(w);
        //0 index is profit, 1 index is capital
        PriorityQueue<int[]> sorted =new  PriorityQueue<>( (x, y) -> x[1]-y[1]);
        for(int i=0; i<profits.length; i++){
            sorted.offer(new int[]{profits[i], capital[i]});
        }
        //proft, capital
        PriorityQueue<int[]> pq=new PriorityQueue<> ( ( x, y) ->  y[0]-x[0]);
        int[] sortedProfits=new int[profits.length];
        int[] sortedCapital=new int[profits.length];
        int index=0;
        while(!sorted.isEmpty()){
            int[] curr=sorted.poll();
            sortedProfits[index]=curr[0];
            sortedCapital[index]=curr[1];
            index++;
        }
        index=0;
        int currCapital=w;
        int currProject=0;
        while(index < sortedCapital.length && sortedCapital[index]<= currCapital ){
            pq.offer(new int[]{sortedProfits[index], sortedCapital[index]});
            index++;
        }
        int currProfit=w;
        while(!pq.isEmpty() && currProject < k ){
            int[] curr=pq.poll();
            //currCapital-=curr[1];
            currCapital+=curr[0];
            currProfit+=curr[0];
            
            currProject++;
            while(index < sortedCapital.length && sortedCapital[index]<= currCapital ){
                pq.offer(new int[]{sortedProfits[index], sortedCapital[index]});
                index++;
            }
            
        }
        return currCapital;
    }
}