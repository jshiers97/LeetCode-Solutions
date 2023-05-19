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
    boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
         balanced(root);
         return balanced;
        
    }
    public int balanced(TreeNode curr){
        if(curr==null){
            return 0; 
        }
        int left=balanced(curr.left); 
        int right=balanced(curr.right);
        if(Math.abs(right-left) > 1){
            balanced=false;
        }
        return Math.max(left, right) + 1;
    }
}