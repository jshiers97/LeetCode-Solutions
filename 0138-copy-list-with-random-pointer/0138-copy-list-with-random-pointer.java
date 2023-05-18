/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map=new HashMap<>();
        Node sent=head;
        while(head!=null){
            Node copy=new Node(head.val);
            map.put(head, copy); 
            head=head.next;
        }
        head=sent;
        while(head!=null){
            Node copy=map.get(head);
            copy.next=map.get(head.next);
            copy.random=map.get(head.random);
            head=head.next;
        }
        return map.get(sent); 
    }
}