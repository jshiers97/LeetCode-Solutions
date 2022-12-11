class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        this.map=new HashMap<String, List<Pair<String, Integer>>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            
            map.put(key, new ArrayList<Pair<String, Integer>>());
        }

        map.get(key).add(new Pair<String, Integer>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(map.containsKey(key) && map.get(key).size()>0){
            return find( timestamp, map.get(key));
        }
        else{
            
            return "";
        }
        
    }
    public String find(int timestamp, List<Pair<String, Integer>> list){
        // int high;
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i).getValue() <= timestamp){
                return list.get(i).getKey();
            }
        }
        return "";
    }
                    
                    
                    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */