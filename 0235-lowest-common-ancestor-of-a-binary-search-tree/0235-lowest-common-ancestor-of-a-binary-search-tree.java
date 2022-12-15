/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res;
        if(q.val > p.val){
            res=helper(root, p, q);
        }
        else{
            res=helper(root, q, p);
            
        }
        return res;
    }
    // p val is less than q val
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }
        else if(root.val < p.val){
            return helper(root.right, p, q);
        }
        else{
            return helper(root.left, p, q);
        }
    }
}