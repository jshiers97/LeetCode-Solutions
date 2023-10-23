class MyCircularQueue {

    ListNode head=new ListNode(-1);
    ListNode tail=new ListNode(-1); 
    
    ListNode hPtr=head;
    ListNode tPtr=head;
    int size; 
    int k; 
    public MyCircularQueue(int k) {
        this.k=k;
        this.size=0; 
        head.next=tail;
        tail.next=head;
    }
    
    public boolean enQueue(int value) {
        if(size==k){
            return false;
        }
        ListNode insert=new ListNode(value); 
        if(size==0){
            tPtr=head;
            hPtr=head;
            hPtr.next=insert;
            insert.next=tPtr; 
            hPtr=insert;
            tPtr=insert;
        }
        else{
            tPtr.next=insert;
            tPtr=insert;
        }
        tPtr.next=tail; 
        size++; 
        return true;
    }
    
    public boolean deQueue() {
        if(hPtr.val!=-1){
            hPtr=hPtr.next;
            head.next=hPtr; 
            size--; 
            if(size==0){
                hPtr=head;
                tPtr=head;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public int Front() {
        return hPtr.val; 
    }
    
    public int Rear() {
        return tPtr.val; 
    }
    
    public boolean isEmpty() {
        if(hPtr.val==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        return size==k; 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */