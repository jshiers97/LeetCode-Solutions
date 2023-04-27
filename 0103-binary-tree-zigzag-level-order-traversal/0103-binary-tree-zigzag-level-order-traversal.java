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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output=new ArrayList<>(); 
        if(root==null){
            return output; 
        }
        boolean left=true; 
        LinkedList<TreeNode> q=new LinkedList<>(); 
        LinkedList<Integer> levelList=new LinkedList<>(); 
        int depth=0;
        q.offer(root);
        q.offer(null); 
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            
            if(curr==null){
                output.add(levelList);
                levelList=new LinkedList<>();
                left=!left;
                if(!q.isEmpty()){
                    q.offer(null); 
                }
            }else{
                
                
                
                if(left==false){
                    levelList.addFirst(curr.val);
                }
                else{
                    levelList.addLast(curr.val); 
                    
                }
                
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right); 
                }
            }
        }
        return output; 
    }
}