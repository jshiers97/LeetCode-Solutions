class Solution {
    class Cell{
        int x;
        int y; 
        Double cost;
        public Cell(int x, Double cost){
            this.x=x;
         
            this.cost=cost; 
            
        }
        
    }
    Map<Integer, List<Pair<Integer,Double>>> adjList=new HashMap<>(); 
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>()); 
            
        }
        double[] probs=new double[n];
        
        for(int i=0; i<edges.length; i++){
            int[] edge=edges[i];
            int src=edge[0];
            int dst=edge[1];
            //first is node, second is prob
            Pair<Integer, Double> p=new Pair<>(dst, succProb[i]);
            adjList.get(src).add(p); 
            
            adjList.get(dst).add(new Pair<Integer, Double>(src, succProb[i]));
        }
        PriorityQueue<Cell> pq=new PriorityQueue<Cell>( (x, y) -> y.cost.compareTo(x.cost));
        pq.offer(new Cell(start_node, 1.0)); 
        //pq.offer(new Edge(start_node, ))
        while(!pq.isEmpty()){
            Cell curr=pq.poll(); 
            //System.out.println(curr.y); 
            int start=curr.x; 
            double prob=curr.cost; 
            if(start==end_node){
                return prob;
            }
            if(adjList.get(start).size() > 0){
                for(Pair<Integer, Double> p : adjList.get(start)){
                    Integer neighbor=p.getKey(); 
                    double temp=prob * p.getValue();
                    if(temp > probs[neighbor]){
                        //System.out.println("here");
                        probs[neighbor]=temp;
                        pq.offer(new Cell(neighbor,  temp));
                        
                    }
                }
            }
        }
        return probs[end_node];
        
    }
}