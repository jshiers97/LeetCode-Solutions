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

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode parent;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
 }
class Solution {
    
  
 
 
    int deepest; 
    Set<TreeNode> lowest; 
    TreeNode res; 
    Queue<TreeNode> q; 
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        create(root, null); 
        this.deepest=1;
        max(root,1); 
        this.lowest=new HashSet<>(); 
        this.res=root; 
        this.q=new LinkedList<>(); 
        enroll(root,1); 
        if(lowest.size()==1){
            return res;
        }
        iterate(root); 
        return res; 
        
        
    }
    public void create(TreeNode current, TreeNode parent){
        current.parent=parent;
        if(current.left!=null){
            create(current.left, current); 
        }
        if(current.right!=null){
            create(current.right, current); 
        }
        return;
    }
    public void max(TreeNode current, int depth){
        deepest=Math.max(deepest, depth); 
        if(current.left!=null){
            max(current.left, depth+1); 
        }
        if(current.right!=null){
            max(current.right, depth+1); 
        }
        return;
    }
    public void enroll(TreeNode current, int depth){
        if(depth==deepest){
            res=current;
            lowest.add(current);  
        }
        if(current.left!=null){
            enroll(current.left, depth+1); 
        }
        if(current.right!=null){
            enroll(current.right, depth+1); 
        }
        return; 
    }
    public boolean iterate(TreeNode current){
        if(current==null){
            return false;
        }
        int left=iterate(current.left)? 1:0;
        int right=iterate(current.right) ? 1:0;
        int mid=(lowest.contains(current)) ? 1:0;
        if(left+right+mid>=2){
            res=current;
            
        }
        return (mid+left+right >0)? true: false;
        
    }
    
}