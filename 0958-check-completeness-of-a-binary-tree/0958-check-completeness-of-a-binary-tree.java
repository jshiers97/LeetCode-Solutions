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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>(); 
        q.offer(root);
        q.offer(null);
        boolean end=false;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                if(q.size() > 0){
                    q.offer(null); 
                    
                }
                else{
                    return true;
                }
            }
            else{
                //System.out.println(curr.val);
                if((end && curr.left!=null) || (end && curr.right!=null)){
                    //System.out.println("here1");
                    return false;
                }
                if(curr.left==null && curr.right!=null){
                    //System.out.println("here");
                    return false;
                }
                else if(curr.left!=null && curr.right==null){
                    end=true;
                    q.offer(curr.left);
                }
                else if(curr.left!=null && curr.right!=null){
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                else{
                    end=true;
                    
                }
            }
        }
        return true;
    }
}