class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts=new HashMap<>();
        //Set<String> once=new HashSet<>();
        //Set<String> need=new HashSet<>(); 
        for(String str: cpdomains){
            String[] arr=str.split("\\s");
            String num=arr[0];
            System.out.println(num); 
            String tempDomain=arr[1];
            System.out.println(tempDomain); 
            String[] domains=tempDomain.split("\\.");
            System.out.println(domains[0]);
            StringBuilder curr=new StringBuilder(); 
            for(int i=domains.length-1; i>=0; i--){
                
                curr.insert(0,domains[i]);
                System.out.println(curr.toString()); 
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