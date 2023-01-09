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
    int count=0;
    public int goodNodes(TreeNode root) {
      
        int prev=root.val;
        helper(root, root.val);
        return count;
    }
    public void helper(TreeNode current, int val){
        if(current.val >= val){
            count++;
        }
        if(current.left!=null){
            helper(current.left, Math.max(val, current.val));
        }
        if(current.right!=null){
            helper(current.right, Math.max(val, current.val));
        }
        return;
    }
}