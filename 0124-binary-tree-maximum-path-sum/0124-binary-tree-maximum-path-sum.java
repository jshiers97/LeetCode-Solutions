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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int temp=recurse(root);
        maxSum=Math.max(maxSum, temp);
        return maxSum;
        
    }
    public int recurse(TreeNode current){
        if(current==null){
            return 0;
        }
        
        int gainFromLeft=Math.max(recurse(current.left),0);
        int gainFromRight=Math.max(recurse(current.right),0);
        maxSum=Math.max(gainFromLeft+gainFromRight + current.val, maxSum);
        int currMax=Math.max(gainFromLeft, gainFromRight)+current.val;
        return currMax;
    }
}