public class Node {
    Node next=null;
    Node prev=null;
    int val;
    int key;
    public Node(int val){
        this.val=val;
            
    }
}
class LRUCache {
    
    int size=0; 
    Node head=new Node(-1);
    Node tail=new Node(-1);
    
    
    
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity=capacity; 
        this.map=new HashMap<>(); 
        head.next=null;
        tail.next=head;
        tail.prev=head; 
        head.prev=tail;
    }
    
    public int get(int key) {
        Node iter=tail.next;
        
        int ret=-1;
        if(map.containsKey(key)){
            Node temp=map.get(key);
            ret=temp.val;
            remove(temp);
            put(key,temp.val);
            
        }
        
        return ret; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node swap=map.get(key);
            remove(swap);
            map.remove(key); 
        }
        Node p= head.prev;
        Node insert=new Node(value); 
        p.next=insert;
        insert.prev=p;
        insert.next=head;
        insert.key=key;
        map.put(key, insert); 
        head.prev=insert; 
        size++;
        if(size>capacity){
            remove(tail.next); 
        }
        
        //System.out.println(head.prev.val); 
    }
    public void remove(Node curr){
        Node p=curr.prev;
        Node n=curr.next;
        p.next=n;
        n.prev=p;
        size--;
        map.remove(curr.key); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */