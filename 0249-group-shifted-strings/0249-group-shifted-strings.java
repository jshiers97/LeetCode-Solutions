class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map=new HashMap<>(); 
        map.put("1", new ArrayList<>());
        for(int i=0; i<strings.length; i++){
            String str=strings[i];
            if(str.length()==1){
                map.get("1").add(str);
                continue;
            }
            String key=make(str);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>()); 
            }
            map.get(key).add(str); 
        }
        List<List<String>> output=new ArrayList<>(); 
        for(String str: map.keySet()){
            if(map.get(str).size()>0){
              output.add(map.get(str));  
            }
            
        }
        return output; 
    }
    public String make(String str){
        char[] chars=str.toCharArray(); 
        StringBuilder key=new StringBuilder(); 
        for(int i=1; i<chars.length; i++){
            char c=chars[i-1];
            char d=chars[i];
            int diff=(c-d + 26)%26;
            key.append(diff + "%");
        }
        return key.toString(); 
    }
}