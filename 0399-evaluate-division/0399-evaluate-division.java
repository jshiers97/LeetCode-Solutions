class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String ,Double>>> map=new HashMap<>(); 
        for(int i=0; i<equations.size(); i++){
            List<String> list=equations.get(i); 
            String src=list.get(0);
            String dst=list.get(1);
            double val=values[i];
            if(!map.containsKey(src)){
                map.put(src, new ArrayList<>()); 
            }
            if(!map.containsKey(dst)){
                map.put(dst, new ArrayList<>()); 
            }
            map.get(src).add(new Pair<>(dst, val)); 
            map.get(dst).add(new Pair<>(src, 1/val)); 
        }
        double[] res=new double[queries.size()];
        int index=0; 
        for(List<String> query: queries){
            String top=query.get(0);
            String bottom=query.get(1); 
            if(map.containsKey(top) && map.containsKey(bottom)){
                double val=bfs(top, bottom, map); 
                res[index++]=val;
            }
            else{
                res[index++]=-1.0; 
            }
            
        }
        return res;
    }
    public double bfs(String top, String bottom, Map<String, List<Pair<String, Double>>> map){
        Queue<Pair<String, Double>> q=new LinkedList<>(); 
        Set<String> seen=new HashSet<>(); 
        q.offer(new Pair<>(top, 1.0)); 
        seen.add(top); 
        while(!q.isEmpty()){
            Pair<String, Double> p=q.poll(); 
            String curr=p.getKey();
            double val=p.getValue(); 
            if(curr.equals(bottom)){
                return val; 
            }
            if(!map.containsKey(curr)){
                continue;
            }
            else{
                List<Pair<String, Double>> l=map.get(curr); 
                for(Pair<String, Double> pair : l){
                    String n=pair.getKey(); 
                    double v=pair.getValue(); 
                    if(!seen.contains(n)){
                        q.offer(new Pair<>(n, v*val));
                        seen.add(n); 
                    }
                }
            }
        }
        return -1.0; 
    }
}