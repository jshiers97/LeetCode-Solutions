class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts=new HashMap<>();
       
        for(String str: cpdomains){
            String[] arr=str.split("\\s");
            String num=arr[0];
           
            String tempDomain=arr[1];
            
            String[] domains=tempDomain.split("\\.");
           
            StringBuilder curr=new StringBuilder(); 
            for(int i=domains.length-1; i>=0; i--){
                
                curr.insert(0,domains[i]);
                
                if(!counts.containsKey(curr.toString())){
                    counts.put(curr.toString(), 0);
                }
                counts.put(curr.toString(), counts.get(curr.toString()) + Integer.parseInt(num));
                curr.insert(0, ".");
            }
            
        }
        List<String> res=new ArrayList<>();
        for(String key: counts.keySet()){
            String temp= counts.get(key) + " " + key; 
            res.add(temp); 
        }
        return res; 
    }
}