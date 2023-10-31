class LockingTree {

    class TreeNode{
        List<TreeNode> children=new ArrayList<>();
        Integer parent=null;
        boolean locked=false;
        Integer locker=null;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
        
    }
    
    Map<Integer, TreeNode> map=new HashMap<>();
    
    public LockingTree(int[] parent) {
        for(int i=0; i<parent.length; i++){
            TreeNode insert=new TreeNode(i);
            insert.parent=parent[i];
            map.put(i, insert);
        }
        iterate(parent, 0);
        
    }
    
    public boolean lock(int num, int user) {
        TreeNode node=map.get(num);
        if(node.locked==false){
            node.locked=true;
            node.locker=user;
            map.put(num, node);
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        TreeNode node=map.get(num);
        if(node.locked==true && node.locker==user){
            node.locked=false;
            node.locker=null;
            map.put(num, node);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        TreeNode check=map.get(num);
        if(canUpgrade(check) && canUpgradeDescendant(check)){
            upgrader(check);
            check.locked=true;
            check.locker=user;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean canUpgrade(TreeNode check){
        if(check.parent==-1 && check.locked==false){
            return true;
        }
        else if(check.locked==true){
            return false;
        }
        else{
            return canUpgrade(map.get(check.parent));
        }
        
    }
    
    public boolean canUpgradeDescendant(TreeNode check){
        if(check==null){
            return false;
        }
        if(check.locked){
            return true;
        }
        boolean fine=false;
        for(TreeNode child: check.children){
            fine=fine || canUpgradeDescendant(child);
            if(fine){
                return true;
            }
        }
        return fine; 
    }
    public void iterate(int[] parent, int index ){
        for(int i=1; i<parent.length; i++){
            TreeNode curr=map.get(i);
            TreeNode par=map.get(parent[i]);
            par.children.add(curr);
        }
    }
    public void upgrader(TreeNode check){
        if(check==null){
            return;
        }
        check.locked=false;
        for(TreeNode child: check.children){
            upgrader(child); 
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */