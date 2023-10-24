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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null; 
        }
        
        if(key<root.val){
            root.left=deleteNode(root.left, key); 
        }
        else if(key > root.val){
            root.right=deleteNode(root.right, key); 
        }
        else{
            //node is a leaf
            if(root.left==null && root.right==null){
                root=null;
            }
            //node is not leaf and has right child
            else if(root.right!=null){
                TreeNode iter=root.right;
                while(iter.left!=null){
                    iter=iter.left;
                }
                root.val=iter.val;
                root.right=deleteNode(root.right, root.val); 
            }
            //node is not leaf and left child 
            else{
                TreeNode iter=root.left;
                while(iter.right!=null){
                    iter=iter.right;
                    
                }
                root.val=iter.val;
                root.left=deleteNode(root.left, root.val); 
            }
        }
        return root;
    }
}