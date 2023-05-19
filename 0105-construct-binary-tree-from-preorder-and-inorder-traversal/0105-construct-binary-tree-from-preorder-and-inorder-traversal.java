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
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);
    }
    public TreeNode build(int[] preorder, int left, int right){
        if(left > right){
            return null; 
        }
        
        int val=preorder[preorderIndex++];
        TreeNode insert=new TreeNode(val);
        //System.out.println(insert.val); 
        insert.left=build(preorder, left, inorderIndexMap.get(val)-1);
        insert.right=build(preorder, inorderIndexMap.get(val)+1, right);
        return insert; 
    }
}