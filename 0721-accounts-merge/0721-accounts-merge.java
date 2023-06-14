class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<String> names=new ArrayList<>();
        for(List<String> list: accounts){
            String name=list.get(0); 
            names.add(name); 
        }
        int[] root=new int[names.size()];
        for(int i=0; i<root.length; i++){
            root[i]=i;
        }
        
        Map<String, Integer> map=new HashMap<>(); 
        for(int i=0; i<accounts.size(); i++){
            List<String> list=accounts.get(i); 
            for(int j=1; j<list.size(); j++){
                String str=list.get(j); 
                if(!map.containsKey(str)){
                    map.put(str, i);
                }
                else{
                    if(names.get(i).equals(names.get(map.get(str)))){
                        int temp=root[map.get(str)];
                        for(int k=0; k<root.length; k++){
                            if(root[k]==temp){
                                root[k]=i;
                            }
                        }
                    
                    }
                }
            }
            
        }
    
        Set<Integer> toDo=new HashSet<>(); 
        List<List<String>> lists=new ArrayList<>();
        for(int i=0; i<root.length; i++){
            toDo.add(root[i]);
            
        }
        for(int x: toDo){
            Set<String> set=new HashSet<>(); 
            for(String str: map.keySet()){
                if(root[map.get(str)]==x){
                    set.add(str); 
                }
            }
            List<String> list=new ArrayList<>(set); 
            Collections.sort(list); 
            list.add(0, names.get(x));
            lists.add(list); 
        }
   
        
        
        
        return lists; 
    }
}
    