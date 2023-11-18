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
    int res=0; 
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode curr){
        if(curr==null){
            return 0;
        }
        int left=dfs(curr.left);
        int right=dfs(curr.right); 
        res+=Math.abs(left) + Math.abs(right);
       
        return left + right + curr.val -1;
    }
}