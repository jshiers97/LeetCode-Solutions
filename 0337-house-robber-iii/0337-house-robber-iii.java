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
    Map<TreeNode, Integer> rob=new HashMap<>();
    Map<TreeNode, Integer> skipRob=new HashMap<>();
    
    int max=0; 
    public int rob(TreeNode root) {
        return iterate(root, true);
        //iterate(root, false, root.val);
        //return max;
    }
    public int iterate(TreeNode node, boolean canTake){
        if(node==null){
            return 0;
        }
        
        if(canTake){
            if(rob.containsKey(node)){
                return rob.get(node);
            }
            int skip=iterate(node.left, canTake) + iterate(node.right, canTake);
            int take=node.val + iterate(node.left, false) + iterate(node.right, false);
            rob.put(node, Math.max(skip, take));
            return Math.max(skip, take); 
            
        }
        else{
            if(skipRob.containsKey(node)){
                return skipRob.get(node); 
            }
            int skip=iterate(node.left, true) + iterate(node.right, true);
            return skip; 
        }
    }
}