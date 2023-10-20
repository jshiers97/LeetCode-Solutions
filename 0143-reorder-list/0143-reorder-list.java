/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode sent=head;
        int size=0;
        ListNode iter=head;
        while(iter!=null){
            size++;
            iter=iter.next;
        }
        int half=size/2;
        if(size%2==1){
            half++;
            
        }
        iter=head;
        half--;
        while(half > 0){
            iter=iter.next;
            half--; 
        }
        ListNode temp=iter.next;
        
        ListNode secondHead=reverse(temp);
        
        iter.next=null;
        
        
        
        iter=head;
        iter=iter.next;
        ListNode secondIter=secondHead.next;
        while(iter!=null){
            head.next=secondHead;
            secondHead.next=iter;
            head=iter;
            if(secondIter!=null){
                secondHead=secondIter;
                secondIter=secondIter.next;
            }
            iter=iter.next;
        }
        if(size%2==0){
            head.next=secondHead;
        }
        
        
        
    }
    public ListNode reverse(ListNode node){
        Stack<ListNode> stack=new Stack();
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
        ListNode newHead=stack.pop(); 
        ListNode sent=newHead;
        while(!stack.isEmpty()){
            newHead.next=stack.pop();
            newHead=newHead.next;
        }
        newHead.next=null; 
        return sent;
    }
}