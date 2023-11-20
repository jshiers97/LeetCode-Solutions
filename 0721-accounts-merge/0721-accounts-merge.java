class Solution {
    int[] root;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<String>> map=new HashMap<>(); 
        for(int i=0; i<accounts.size(); i++){
            map.put(i, new HashSet<>()); 
            for(int j=1; j<accounts.get(i).size(); j++){
                String str=accounts.get(i).get(j);
                map.get(i).add(str);
            }
        }
        this.root=new int[accounts.size()];
        for(int i=0; i<root.length; i++){
            root[i]=i;
        }
        Set<Integer> skip=new HashSet<>();
        boolean cont=true;
        while(cont){
            cont=false;
            for(int i=0; i<accounts.size(); i++){
                if(skip.contains(i)){
                    continue;
                }
                for(int j=i+1; j<accounts.size(); j++){
                    if(skip.contains(j)){
                        continue;
                    }
                    
                    Set<String> set1=map.get(i);
                    Set<String> set2=map.get(j);
                    boolean added=false;
                    for(String str1: set1){
                        if(set2.contains(str1)){
                            union(i, j);
                            skip.add(j);
                            added=true;
                            break;
                            
                        }
                    }
                    if(added){
                        for(String str: set2){
                            map.get(i).add(str);
                        }
                        cont=true;
                    }
                }
            }
        }
        List<List<String>> res=new ArrayList<>(); 
        for(int i=0; i<root.length; i++){
            if(skip.contains(i)){
                continue;
            }
            else{
                List<String> insert=new ArrayList<>(); 
                for(String str: map.get(i)){
                    insert.add(str);
                }
                Collections.sort(insert); 
                insert.add(0, accounts.get(i).get(0));
                res.add(insert);
            }
        }
        return res;
        
    }
    public int find(int x){
        return root[x];
    }
    public void union(int x, int y){
        int findX=find(x);
        int findY=find(y); 
        if(findX!=findY){
            for(int i=0; i<root.length; i++){
                if(root[i]==findY){
                    root[i]=findX; 
                }
            }
        }
    } 
}