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
    List<Node> list;
    public Node inorderSuccessor(Node node) {
        int val=node.val;
        Node temp=node;
        while(node.parent!=null){
            node=node.parent; 
        }
        this.list=new ArrayList<>(); 
        recurse(node, val); 
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==temp){
                if(i+1<list.size()){
                    return list.get(i+1);
                }
                else{
                    return null;
                }
            }
        }
        return null; 
    }
    public void recurse(Node node, int val){
        if(node==null){
            return;
            
        }
        recurse(node.left, val);
        list.add(node);
        recurse(node.right, val);
        return;
        
    }
}