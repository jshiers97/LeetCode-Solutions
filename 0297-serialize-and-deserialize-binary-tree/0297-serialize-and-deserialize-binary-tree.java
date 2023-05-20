/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;
    StringBuilder str=new StringBuilder(); 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        construct(root);
        str.deleteCharAt(str.length()-1); 
        return str.toString(); 
        
    }
    public void construct(TreeNode curr){
        if(curr==null){
            str.append("N");
            str.append("#");
        }
        else{
            str.append(curr.val);
            str.append("#");
            construct(curr.left); 
            construct(curr.right); 
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr=data.split("#");
        
        return reconstruct(arr); 
    }
    public TreeNode reconstruct(String[] arr){
        if(index==arr.length){
            return null;
        }
        String temp=arr[index];
         
        if(temp.equals("N")){
            return null; 
        }
        int val=Integer.parseInt(temp); 
        TreeNode curr=new TreeNode(val); 
        index++;
        curr.left=reconstruct(arr);
        index++;
        curr.right=reconstruct(arr);
        return curr; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));