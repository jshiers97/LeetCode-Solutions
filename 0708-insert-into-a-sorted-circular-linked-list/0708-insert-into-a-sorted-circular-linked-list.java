/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node n=new Node(insertVal);
            n.next=n;
            return n;
            
        }
        if(head.next==head){
            Node n=new Node(insertVal);
            if(insertVal >= head.val){
                head.next=n;
                n.next=head;
            }
            else{
                n.next=head;
                head.next=n;
            }
            return head;
        }
        int min=head.val;
        int max=head.val;
        Node iter=head.next;
        while(iter!=head){
            if(iter.val > max){
                max=iter.val;
            }
            if(iter.val < min){
                min=iter.val;
            }
            iter=iter.next;
        }
        if(insertVal >= max){
            addGreatest(head, insertVal, max);
            return head;
        }
        else if(insertVal <=min){
            addSmallest(head, insertVal, max);
            return head;
        }
        else{
            Node p=head;
            Node n=head.next;
            boolean first=true;
            System.out.println("here");
            while(p!=head || first){
                if(p==head){
                    first=false;
                }
                if(insertVal >= p.val && insertVal <=n.val){
                    Node insert=new Node(insertVal); 
                    p.next=insert;
                    insert.next=n;
                    return head;
                }
                p=p.next;
                n=n.next;
            }
            return head;
            
        }
        
        
    }
    public void addGreatest(Node head, int insertVal, int max){
        
        Node p=head;
        while(p.val!=max){
            p=p.next;
        }
        System.out.println(p.val);
        while(p.next.val==max){
            p=p.next;
            
        }
         System.out.println(p.val);
        Node adding=new Node(insertVal);
        Node temp=p.next;
        p.next=adding;
        adding.next=temp;
        return;
        
        
    }
    public void addSmallest(Node head, int insertVal, int min){
       
        Node p=head;
        while(p.val!=min){
            p=p.next;
        }
        while(p.next.val==min && p!=head){
            p=p.next;
            
        }
        Node adding=new Node(insertVal);
        Node temp=p.next;
        p.next=adding;
        adding.next=temp;
        return;
    }
}