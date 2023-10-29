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
    int curr=0;
    public TreeNode convertBST(TreeNode root) {
        iterate(root);
        return root;
    }
    public void iterate(TreeNode root){
        if(root==null){
            return;
        }
        iterate(root.right);
        int temp=root.val;
        root.val=root.val + curr;
        curr+=temp;
        iterate(root.left);
        return;
        
    }
}