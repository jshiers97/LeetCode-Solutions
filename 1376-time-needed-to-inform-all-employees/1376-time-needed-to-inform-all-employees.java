class Solution {
    int curr=0; 
    class TreeNode{
        List<TreeNode> children=new ArrayList<>();
        int val;
        public TreeNode(int val){
            this.val=val;
            
        }
    }
    Map<Integer, TreeNode> map=new HashMap<>();
    Map<Integer, Integer> depths=new HashMap<>(); 
    int maxDepth=0;
    int max=0;
    int[] manager;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for(int i=0; i<n; i++){
            TreeNode node=new TreeNode(i);
            map.put(i, node);
        }
        map.put(-1, new TreeNode(-1));
        depths.put(-1, 0);
        for(int i=0; i<n; i++){
            int man=manager[i];
            TreeNode parent=map.get(man);
            parent.children.add(map.get(i));
        }
        this.manager=manager;
        depths.put(-1, 0);
        solve(map.get(-1).children.get(0), informTime);
        //System.out.println(depths.get(6));
        return max;
    }
    public void solve(TreeNode node, int[] informTime){
        if(node.children.size()==0){
            return;
        }
        
        
        if(!depths.containsKey(node.val)){
            
            depths.put(node.val, depths.get(manager[node.val]) + informTime[node.val]);
            max=Math.max(max, depths.get(node.val));
        }
        
        
        for(TreeNode child: node.children){
            
            solve(child, informTime );
        }
    }
}