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
    int ret=-1; 
    public int kthSmallest(TreeNode root, int k) {
        recurse(root, k);
        return ret; 
    }
    public void recurse(TreeNode curr, int k){
        if(curr==null){
            return;
        }
        
        recurse(curr.left, k); 
        count++;
        if(count==k){
           
            ret=curr.val;
            

        }
        recurse(curr.right, k); 
    }
}