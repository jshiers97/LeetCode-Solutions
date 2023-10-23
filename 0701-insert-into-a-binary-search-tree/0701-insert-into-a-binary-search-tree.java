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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val); 
        }
        insert(root,null, null, val);
        return root;
    }
    public void insert(TreeNode curr, Integer low, Integer high, int val){
        if(curr.val < val ){
            if(curr.right==null){
                TreeNode insert=new TreeNode(val);
                curr.right=insert;
                return;
            }
            else{
                insert(curr.right, low, high, val); 
            }
        }
        else if(curr.val > val){
            if(curr.left==null){
                TreeNode insert=new TreeNode(val);
                curr.left=insert;
                return;
            }
            else{
                insert(curr.left, low, high, val); 
            }
        }
    }
}