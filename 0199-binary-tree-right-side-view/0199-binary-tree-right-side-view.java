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
    List<Integer> output=new ArrayList<>(); 
    public List<Integer> rightSideView(TreeNode root) {
        recurse(root, 0);
        return output; 
    }
    public void recurse(TreeNode curr, int depth){
        if(curr==null){
            return; 
        }
        if(depth==output.size()){
            output.add(curr.val); 
        }
        recurse(curr.right, depth+1);
        recurse(curr.left, depth+1); 
        return; 
    }
}