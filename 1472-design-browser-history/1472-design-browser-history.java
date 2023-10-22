class BrowserHistory {
    class ListNode{
        String val;
        ListNode prev;
        ListNode next;
        public ListNode(String val){
            this.val=val;
        }
    }

    ListNode head=new ListNode("1");
    ListNode tail=new ListNode("1");
    ListNode iter=head;
    public BrowserHistory(String homepage) {
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null; 
        //ListNode iter=head; 
        ListNode insert=new ListNode(homepage);
        head.next=insert;
        insert.next=tail;
        tail.prev=insert;
        insert.prev=head; 
        
        iter=insert; 
    }
    
    public void visit(String url) {
        ListNode insert=new ListNode(url); 
        insert.next=tail;
        tail.prev=insert;
        iter.next=insert;
        insert.prev=iter;
        iter=insert;
    }
    
    public String back(int steps) {
        ListNode backpedal=iter;
        int count=steps;
        while(steps>0 && backpedal.prev!=head){
            backpedal=backpedal.prev;
            steps--;
        }
        iter=backpedal;
        return backpedal.val; 
    }
    
    public String forward(int steps) {
        ListNode forwardPedal=iter;
        int count=steps;
        while(steps>0 && forwardPedal.next!=tail){
            forwardPedal=forwardPedal.next;
            steps--; 
        }
        iter=forwardPedal;
        return iter.val; 
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */