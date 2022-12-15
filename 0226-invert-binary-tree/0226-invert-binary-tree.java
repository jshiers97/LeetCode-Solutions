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
    public TreeNode invertTree(TreeNode root) {
        return flip(root);
    }
    public TreeNode flip(TreeNode current){
        if(current==null){
            return null;
        }
        TreeNode temp=current.left;
        current.left=flip(current.right);
        current.right=flip(temp);
        return current;
        
        
    }
}