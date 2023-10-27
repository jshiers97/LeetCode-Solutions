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
    int maxDepth=0;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        this.res=root.val;
        iterate(root, 0);
        return res;
    }
    public void iterate(TreeNode curr, int depth){
        if(curr==null){
            return;
        }
        if(depth > maxDepth){
            maxDepth=depth;
            res=curr.val;
        }
        iterate(curr.left, depth+1);
        iterate(curr.right, depth+1);
        
    }
}