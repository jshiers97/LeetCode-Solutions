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
        
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //reverse second part of list
        ListNode prev=null;
        ListNode curr=slow;
        ListNode tmp;
        while(curr!=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
    
        
        //merge
        ListNode first=head;
        ListNode second=prev;
        while(second.next!=null){
            tmp=first.next;
            first.next=second;
            first=tmp;
            
            tmp=second.next;
            second.next=first;
            second=tmp;
        }
    }
}