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
    int globalMax=0;
    
    public int maxAncestorDiff(TreeNode root) {
        iterate(root.val, root.val, root);
        return globalMax;
    }
    public void iterate(int min, int max, TreeNode curr){
        if(globalMax < Math.abs(curr.val - min)){
            globalMax=Math.abs(curr.val - min);
        }
        if(globalMax < Math.abs(curr.val - max)){
            globalMax=Math.abs(curr.val - max);
        }
        
        if(curr.left!=null){
            iterate(Math.min(min, curr.val), Math.max(max, curr.val), curr.left);
        }
        if(curr.right!=null){
            iterate(Math.min(min, curr.val), Math.max(max, curr.val), curr.right);
        }
    }
}