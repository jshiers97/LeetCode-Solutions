class MyLinkedList {
    
    class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        public ListNode(int val){
            this.val=val;
            
        }
    }
    int size;
    ListNode tail=new ListNode(-1);
    ListNode head=new ListNode(-1);
    
    public MyLinkedList() {
        this.size=0; 
        head.next=tail;
        tail.next=null; 
    }
    
    public int get(int index) {
        if(index>= size){
            return -1; 
        }
        ListNode iter=head;
        while(iter!=null){
            System.out.println(iter.val);
            iter=iter.next;
        }
        iter=head;
        int count=index+1; 
        while(count>0){
            iter=iter.next;
            count--; 
        }
        return iter.val; 
    }
    
    public void addAtHead(int val) {
        ListNode temp=head.next;
        ListNode insert=new ListNode(val);
        head.next=insert;
        insert.next=temp; 
        size++; 
        //System.out.println(head.next.val); 
    }
    
    public void addAtTail(int val) {
        ListNode iter=head; 
        int count=size;
        //S/ystem.out.println(size); 
        while(count>0){
            iter=iter.next;
            count--; 
        }
        ListNode insert=new ListNode(val); 
        ListNode temp=iter.next;
        iter.next=insert;
        insert.next=temp; 
        size++; 
        //System.out.println(head.next.next.val); 
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index> size){
            return;
        }
        ListNode iter=head; 
        int count=index; 
        while(count>0){
            iter=iter.next;
            count--; 
        }
        ListNode insert=new ListNode(val); 
        ListNode temp=iter.next;
        iter.next=insert;
        insert.next=temp; 
        size++; 
        //System.out.println(head.next.next.val); 
        
    }
    
    public void deleteAtIndex(int index) {
        if(index>= size){
            return;
        }
        ListNode iter=head; 
        int count=index; 
        while(count>0){
            iter=iter.next;
            count--; 
        }
        //ListNode temp=iter.next;
        iter.next=iter.next.next;
        size--; 
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */