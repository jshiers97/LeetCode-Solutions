/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        int temp=node.val;
        if(node.right==null){
            while(node.parent!=null){
                node=node.parent;
                if(node.val > temp){
                    return node;
                }
            }
            if(node.val <= temp){
                return null; 
            }
            return node; 
        }
        node=node.right;
        while(node.left!=null){
            node=node.left;
        }
        return node; 
    }
}