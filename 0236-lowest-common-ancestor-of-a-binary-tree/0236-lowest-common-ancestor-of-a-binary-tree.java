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
    TreeNode ans=null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        iterate(root, p, q);
        return ans;
        
    }
    public boolean iterate(TreeNode current, TreeNode p, TreeNode q){
        if(current==null){
            return false;
        }
        int left=iterate(current.left, p, q)? 1:0;
        int right=iterate(current.right, p, q) ? 1:0;
        int mid=(current==p || current==q) ? 1:0;
        if(left+right+mid>=2){
            this.ans=current;
            
        }
        return (mid+left+right >0)? true: false;
    }
}