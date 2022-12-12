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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode sent=head;
        ListNode iter=head;
        int size=0;
        while(iter!=null){
            size++;
            iter=iter.next;
        }
        int iterations=size-n;
        if(iterations==0){
            return sent.next;
        }
        iterations--;
        iter=head;
        for(int i=0; i<iterations; i++){
            iter=iter.next;
        }
        iter.next=iter.next.next;
        return sent;
       
        
        
    }
}