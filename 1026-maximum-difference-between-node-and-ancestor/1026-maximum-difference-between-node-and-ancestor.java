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
    int maxDiff=Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        recurse(root.left, root.val, root.val);
        recurse(root.right, root.val, root.val);
        return maxDiff;
    }
    public void recurse(TreeNode curr, Integer min, Integer max){
        if(curr==null){
            return;
        }
        
        if(min!=null){
            maxDiff=Math.max(maxDiff, Math.abs(curr.val-min));
        }
        if(max!=null){
            maxDiff=Math.max(maxDiff, Math.abs(curr.val - max)); 
        }
        if(min==null){
            min=curr.val;
        }
        if(max==null){
            max=curr.val;
        }
        
        recurse(curr.left, Math.min(min, curr.val), Math.max(max, curr.val)  );
        recurse(curr.right, Math.min(min, curr.val), Math.max(max, curr.val)); 
        
    }
}