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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root); 
        return max; 
    }
    public int recurse(TreeNode curr){
        if(curr==null){
            return 0; 
        }
        int left=recurse(curr.left);
        int right=recurse(curr.right);
        //int curr=
        max=Math.max(max, left+right);
        return Math.max((left), (right)) + 1; 
    }
}