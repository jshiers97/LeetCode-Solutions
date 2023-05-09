/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> list=new ArrayList<>(); 
    Map<Integer, List<Integer>> map=new HashMap<>(); 
    int left=0; 
    int right=0; 
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null){
            return list; 
        }
        this.left=left;
        this.right=right;
        
        traverse(root, 0); 
        
        for(int i=left; i<=right; i++){
            map.put(i, new ArrayList<>()); 
        }
        Queue<Pair<TreeNode, Integer>> q=new LinkedList<>(); 
       
        q.offer(new Pair<TreeNode, Integer>(root, 0));
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> p=q.poll(); 
            TreeNode curr=p.getKey(); 
            Integer align=p.getValue();
            map.get(align).add(curr.val);
            if(curr.left!=null){
                q.offer(new Pair<TreeNode, Integer>(curr.left, align-1));
            }
            if(curr.right!=null){
                q.offer(new Pair<TreeNode, Integer>(curr.right, align+1));
            }
            
        }
        for(int i=left; i<=right; i++){
            
            list.add(map.get(i)); 
        }
        return list; 
        
        
    }
    public void traverse(TreeNode curr, int pos){
        left=Math.min(left, pos);
        right=Math.max(pos, right); 
       
        if(curr.left!=null){
            
            traverse(curr.left, pos-1); 
        }
        if(curr.right!=null){
            traverse(curr.right, pos+1); 
        }
        
        return; 
    }
}