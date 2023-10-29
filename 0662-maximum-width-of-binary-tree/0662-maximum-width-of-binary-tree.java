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
    public int widthOfBinaryTree(TreeNode root) {
        int max=1;
        Queue<Pair<TreeNode, Integer>> q=new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        //q.offer(null);
        while(!q.isEmpty()){
            int size=q.size();
            Pair<TreeNode, Integer> first=q.peek();
            TreeNode curr=null;
            Pair<TreeNode, Integer> temp=null;
            for(int i=0; i<size; i++){
                temp=q.poll();
                curr=temp.getKey();
                if(curr.left!=null){
                    q.offer(new Pair<>(curr.left, temp.getValue() * 2));
                }
                if(curr.right!=null){
                    q.offer(new Pair<>(curr.right, temp.getValue() * 2 + 1));
                }
                
            }
            max=Math.max(max, temp.getValue() - first.getValue() +1);
            
        }
        return max;
        
    }
}