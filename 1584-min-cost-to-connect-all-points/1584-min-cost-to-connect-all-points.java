class Solution {
    
    class Edge{
        int x;
        int y; 
        int cost; 
        public Edge(int x, int y){
            this.x=x;
            this.y=y;
            this.cost=distance(points[x], points[y]); 
        }
    }
    int[][] points;
    int[] root;
    public int minCostConnectPoints(int[][] points) {
        this.root=new int[points.length];
        this.points=points;
        for(int i=0; i<root.length; i++){
            root[i]=i; 
        }
        PriorityQueue<Edge> q=new PriorityQueue<Edge>( (x, y) -> x.cost-y.cost); 
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int first[]=points[i];
                int second[]=points[j];
                Edge insert=new Edge(i, j);
                q.offer(insert); 
            }
        }
        int min=0; 
        int edges=0;
        while(edges<points.length-1){
            Edge curr=q.poll(); 
            if(find(curr.x)!=find(curr.y)){
                union(curr.x, curr.y); 
                min+=curr.cost; 
                edges++;
            }
        }
        return min; 
    }
    public int distance(int[] first, int[] second){
        int x=Math.abs(first[0]-second[0]);
        int y=Math.abs(first[1]-second[1]);
        return x + y; 
    }
    public void union(int first, int second){
        int findX=find(first);
        int findY=find(second);
        if(findX!=findY){
            for(int i=0; i<root.length; i++){
                if(root[i]==findX){
                    root[i]=findY; 
                }
            }
        }
    }
    public int find(int x){
        return root[x];
    }
    
}