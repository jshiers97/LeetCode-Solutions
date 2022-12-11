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
        int high=list.size()-1;
        int low=0;
        String last="";
        while(low<=high){
            int mid=(low + high)/2;
            if(list.get(mid).getValue()<=timestamp){
                last=list.get(mid).getKey();
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;
    }
                    
                    
                    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */