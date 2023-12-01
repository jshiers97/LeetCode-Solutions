class Solution {
    class Edge{
        int x;
        int y; 
        Double cost;
        public Edge(int x, int y, Double cost){
            this.x=x;
            this.y=y; 
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
        PriorityQueue<Edge> pq=new PriorityQueue<Edge>( (x, y) -> y.cost.compareTo(x.cost));
        for(Pair<Integer, Double> p : adjList.get(start_node)){
            Integer neighbor=p.getKey(); 
            
            probs[neighbor]=p.getValue(); 
            pq.offer(new Edge(start_node, neighbor, p.getValue()));
        }
        while(!pq.isEmpty()){
            Edge curr=pq.poll(); 
            //System.out.println(curr.y); 
            int start=curr.y; 
            double prob=curr.cost; 
            //System.out.println(prob); 
            if(adjList.get(start).size() > 0){
                for(Pair<Integer, Double> p : adjList.get(start)){
                    Integer neighbor=p.getKey(); 
                    double temp=prob * p.getValue();
                    if(temp > probs[neighbor]){
                        //System.out.println("here");
                        probs[neighbor]=temp;
                        pq.offer(new Edge(start, neighbor, temp));
                        
                    }
                }
            }
        }
        return probs[end_node];
        
    }
}