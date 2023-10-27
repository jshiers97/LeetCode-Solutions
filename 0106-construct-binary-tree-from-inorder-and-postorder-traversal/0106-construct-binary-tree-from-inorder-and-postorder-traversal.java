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
    Map<Integer, Integer> map;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int root=postorder[postorder.length-1];
        this.map=new HashMap<>(); 
        this.postIndex=postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        int mid=-1;
        
        return construct(inorder, postorder, 0, postorder.length-1);
        
    }
    public TreeNode construct(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null; 
        }
        int curr=postorder[postIndex--];
        TreeNode insert=new TreeNode(curr);
        insert.right=construct(inorder, postorder, map.get(curr)+1, right);
        insert.left=construct(inorder, postorder, left, map.get(curr)-1);
        return insert;
        
        
        
    }
}