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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null; 
        }
        int size=0; 
        ListNode iter=head;
        while(iter!=null){
            size++;
            iter=iter.next;
        }
        k%=size;
        if(size==k || k==0 || head.next==null){
            return head; 
        }
        
        //int count=k%size; 
        int count=size-k;
        iter=head;
        count--; 
        while(count > 0){
            iter=iter.next;
            count--; 
        }
        ListNode newHead=iter.next;
        iter.next=null; 
        iter=newHead;
        while(iter.next!=null){
            iter=iter.next;
            
        }
        iter.next=head; 
        return newHead;
        
    }
}