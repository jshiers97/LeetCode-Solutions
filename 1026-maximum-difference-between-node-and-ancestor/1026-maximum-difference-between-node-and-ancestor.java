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
    int gmax=0;
    public int maxAncestorDiff(TreeNode root) {
        iterate(root, root.val, root.val);
        return gmax;
    }
    public void iterate(TreeNode curr, int min, int max){
        if(curr==null){
            return;
        }
        if(Math.abs(curr.val - min) > gmax){
            gmax=Math.abs(curr.val-min);
        }
        if(Math.abs(curr.val - max) > gmax){
            gmax=Math.abs(curr.val-max);
        }
        iterate(curr.left, Math.min(min, curr.val), Math.max(curr.val, max));
        iterate(curr.right, Math.min(min, curr.val), Math.max(curr.val, max));
        return;
    }
}