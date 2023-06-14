class SnapshotArray {
    //List<List<Integer>> snaps=new ArrayList<>(); 
    List<Integer> array;
    Map<Integer, List<Pair<Integer, Integer>>> map=new HashMap<>(); 
    int snapId=0;
    public SnapshotArray(int length) {
        this.array=new ArrayList<>();
        for(int i=0; i<length; i++){
            array.add(0);
        }
        
        for(int i=0; i<array.size(); i++){
            map.put(i, new ArrayList<>()); 
            //snapId, value
            map.get(i).add(new Pair<>(snapId, array.get(i))); 
        }
    }
    
    public void set(int index, int val) {
        int size=map.get(index).size();
        if(map.get(index).get(size-1).getKey()==snapId){
            map.get(index).remove(size-1);
            map.get(index).add(new Pair<>(snapId, val)); 
        } 
        else{
            map.get(index).add(new Pair<>(snapId, val)); 
        }
    }
    
    public int snap() {
        
        snapId++;
        return snapId-1; 
    }
    
    public int get(int index, int snap_id) {
        List<Pair<Integer, Integer>> list=map.get(index); 
        int left=0;
        int temp=0;
        int right=list.size()-1; 
        while(left <= right){
            int mid=(left+right)/2; 
            Pair<Integer, Integer> curr=list.get(mid);
            int oldSnap=curr.getKey(); 
            int val=curr.getValue(); 
            if(oldSnap==snap_id){
                return val; 
            }
            if(oldSnap > snap_id){
                right=mid-1; 
            }
            else{
                temp=val;
                left=mid+1;
            }
        }
        return temp; 
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */