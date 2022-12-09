class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        this.map=new HashMap<>();
        this.list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
      
        int index=map.get(val);
        int temp=list.get(list.size()-1);
        list.set(index, temp);
        list.remove(list.size()-1);
        map.remove(val);
        map.replace(temp, index);
        
        
        
        return true;
        
    }
    
    public int getRandom() {
        int rand=(int)(Math.random() * map.size());
        return list.get(rand);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */