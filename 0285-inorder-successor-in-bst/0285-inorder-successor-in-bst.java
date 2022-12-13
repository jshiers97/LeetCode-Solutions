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
    List<TreeNode> out;
    int index;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.out=new ArrayList<>();
        this.index=-1;
        preorder(root, p);
        for(int i=0; i<out.size(); i++){
            if(out.get(i).val==p.val && i<out.size()-1){
                return out.get(i+1);
            }
        }
        return null;
    }
    public void preorder(TreeNode current, TreeNode p){
        if(current.left!=null){
            preorder(current.left, p);
        }
        out.add(current);
        if(current.right!=null){
            preorder(current.right, p);
        }
        return;
        
    }
}