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
class BSTIterator {

    Stack<TreeNode> stack=new Stack<>(); 
    public BSTIterator(TreeNode root) {
        getLeft(root);
    }
    
    public int next() {
        TreeNode curr=stack.pop();
        //if(curr.righ)
        getLeft(curr.right);
        return curr.val; 
        
    }
    
    public boolean hasNext() {
        return stack.size() > 0; 
        
    }
    public void getLeft(TreeNode curr){
        while(curr!=null){
            stack.push(curr);
            curr=curr.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */