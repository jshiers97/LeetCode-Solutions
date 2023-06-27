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
    Set<Integer> complement=new HashSet<>();
    int target; 
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        this.target=target; 
        recurse(root1); 
        return find(root2); 
        
    }
    public void recurse(TreeNode curr){
        if(curr==null){
            return; 
        }
        int comp=target-curr.val; 
        complement.add(comp); 
        recurse(curr.left); 
        recurse(curr.right); 
        return; 
    }
    public boolean find(TreeNode curr){
        if(curr==null){
            return false;
        }
        if(complement.contains(curr.val)){
            return true; 
        }
        
        return find(curr.left) || find(curr.right); 
    }
}